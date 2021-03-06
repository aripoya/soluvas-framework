package org.soluvas.geo;

import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Normalizer;
import java.text.Normalizer.Form;

import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageImpl;
import org.soluvas.data.domain.Pageable;

import au.com.bytecode.opencsv.CSVReader;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.googlecode.concurrenttrees.radix.ConcurrentRadixTree;
import com.googlecode.concurrenttrees.radix.RadixTree;
import com.googlecode.concurrenttrees.radix.node.concrete.DefaultCharArrayNodeFactory;

public class GeoNamesCountryRepository  implements CountryRepository {
	
	private static final Logger log = LoggerFactory
			.getLogger(GeoNamesCountryRepository.class);
	
	final RadixTree<Country> tree = new ConcurrentRadixTree<>(new DefaultCharArrayNodeFactory());
	final ImmutableMap<String, Country> countryMap;
	final ImmutableMap<String, Country> country3Map;
	private final int realCountryCount = 0;
	
	public GeoNamesCountryRepository() throws IOException{
		super();
		// Countries
		final ImmutableMap.Builder<String, Country> countryMab = ImmutableMap.builder();
		try (final InputStreamReader reader = new InputStreamReader(GeoNamesCountryRepository.class.getResourceAsStream("countryinfo.csv"))) {
			try (final CSVReader csv = new CSVReader(reader, '\t', '"')) {
				while (true) {
					@Nullable
					final String[] line = csv.readNext();
					if (line == null) {
						break;
					}
					if (line[0].startsWith("#")) {
						continue;
					}
					final Country country = new Country(line[0], line[1], line[4]);
					countryMab.put(country.getIso(), country);
				}
			}
		}
		countryMap = countryMab.build();
		log.info("Read {} countries: {}", countryMap.size(), countryMap.keySet());
		country3Map = Maps.uniqueIndex(countryMap.values(), new Function<Country, String>() {
			@Override @Nullable
			public String apply(@Nullable Country input) {
				return input.getIso3();
			}
		});
	}
	
	@Override
	public Country getCountry(String iso2orIso3) throws IllegalArgumentException {
		Country country = countryMap.get(iso2orIso3);
		if (country == null) {
			country = country3Map.get(iso2orIso3);
		}
		Preconditions.checkArgument(country != null,
				"Invalid country ISO code '%s'. %s available countries are: %s.",
				iso2orIso3, countryMap.size(), countryMap.keySet());
		return country;
	}
	
	@Override
	public Page<Country> searchCountry(String term, Pageable pageable) {
		// http://stackoverflow.com/a/3322174/1343587
		final String normalizedTerm = Normalizer.normalize(term, Form.NFD).replaceAll("[^\\p{ASCII}]", "").toLowerCase();
		final FluentIterable<Country> matching = FluentIterable.from(countryMap.values())
			.filter(new Predicate<Country>() {
				@Override
				public boolean apply(@Nullable Country country) {
					return StringUtils.containsIgnoreCase(country.getIso() + " " 
							+ country.getIso3() + " " + country.getName(), normalizedTerm);
				}
			});
		final int total = Iterables.size(matching);
		final ImmutableList<Country> paged = matching
			.skip((int) pageable.getOffset())
			.limit((int) pageable.getPageSize())
			.toList();
		final PageImpl<Country> page = new PageImpl<>(paged, pageable, total);
		log.debug("Searching '{}' ({}) paged by {} returned {} (total {}) countries: {}",
				term, normalizedTerm, pageable, paged.size(), total, Iterables.limit(paged, 10));
		return page;
	}

	@Override
	public long count() {
		return realCountryCount;
	}
	
	public ImmutableMap<String, Country> getCountryMap() {
		return countryMap;
	}

}
