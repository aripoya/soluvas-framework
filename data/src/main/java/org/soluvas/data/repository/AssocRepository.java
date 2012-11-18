package org.soluvas.data.repository;

import java.util.Collection;
import java.util.Map;

import javax.annotation.Nonnull;

import com.google.common.collect.Multimap;

/**
 * Repository that manages left-right pairs. A left-right pair is unique (no duplicates),
 * and has no attached information (unlike graph edges, which are
 * objects in their own right). Only the pair is unique, each left can have
 * multiple rights, and each right can have multiple lefts.
 * 
 * A {@link AssocRepository} is usually used as follows.
 * 
 * 1. Associating IDs with IDs. The L and R generic parameters will be strings,
 *    and no other information is provided.
 * 2. Another interface is used to get a representation objects of LID and RID.
 *    For example LID may represented Role and RID may represent Person.
 *    Usually, the LID is the "owner" of the association.
 *    For example, in Role-Person association in LDAP, the associations
 *    are stored in the <tt>groupOfUniqueNames</tt> entry, hence belonging to the Role.
 *    
 * And ID may be either a "real" ID or a path (e.g. "bags/hobos").
 * It is assumed that IDs are homogenous, i.e. LID is IDs from a
 * particular class and also with RID.
 *  
 * For heterogenous IDs, e.g. likes, where LID can be Person/Shop/Page,
 * and RID can be Product/Shop/Page; IDs need a namespacing mechanism
 * (using URN scheme, path, or QName). Or maybe a job for a different interface
 * (TypedAssocRepository?).
 * 
 * If an AssocRepository has a "vertex" concept, it should automatically create the vertex if
 * the placeholder didn't exist when {@link #put(Object, Object)} is called.
 * During {@link #delete(Object, Object)}, it may delete unused vertices, but may also
 * defer that to a separate "garbage collection" operation.
 * 
 * AssocRepository methods must co-exist with {@link CrudRepository} methods,
 * because {@link EdgeRepository} is a combination between {@link CrudRepository}
 * and AssocRepository. 
 * 
 * Inspired by com.tinkerpop.blueprints.pgm.Graph.
 * @see BiMap, {@link Multimap}
 * @author ceefour
 */
public interface AssocRepository<L, R> extends BasicRepository, BasicAssocRepository<L, R> {

    // Query Operations

    

    // Modification Operations

    /**
     * Stores a left-right pair in the multimap.
     *
     * <p>Some multimap implementations allow duplicate left-right pairs, in which
     * case {@code put} always adds a new left-right pair and increases the
     * multimap size by 1. Other implementations prohibit duplicates, and storing
     * a left-right pair that's already in the multimap has no effect.
     *
     * @param key key to store in the multimap
     * @param value value to store in the multimap
     * @return {@code true} if the method increased the size of the multimap, or
     *     {@code false} if the multimap already contained the left-right pair and
     *     doesn't allow duplicates
     */
    boolean put(@Nonnull L left, @Nonnull R right);

    /**
     * Removes a single left-right pair from the multimap.
     *
     * @param key key of entry to remove from the multimap
     * @param value value of entry to remove the multimap
     * @return {@code true} if the multimap changed
     */
    boolean delete(@Nonnull L left, @Nonnull R right);

    // Bulk Operations

    /**
     * Removes one or more left-right pairs with the same left from the multimap.
     *
     * @param left left of entry to remove from the multimap
     * @param rights rights of entry to remove the multimap
     * @return {@code true} if the multimap changed
     */
    long delete(@Nonnull L left, @Nonnull Iterable<R> rights);

    /**
     * Removes one or more left-right pairs with the same right from the multimap.
     *
     * @param lefts lefts of entry to remove from the multimap
     * @param right right of entry to remove the multimap
     * @return {@code true} if the multimap changed
     */
    long delete(@Nonnull Iterable<L> lefts, @Nonnull R right);

    /**
     * Stores a collection of rights with the same left.
     *
     * @param left left to store in the multimap
     * @param rights rights to store in the multimap
     * @return (Approximate) number of changed edges. 0 if multimap doesn't changed. -1 if changed, but number is not known.
     */
    long save(@Nonnull L left, Iterable<? extends R> rights);

    /**
     * Stores a collection of lefts with the same right.
     * @param key key to store in the multimap
     * @param rights rights to store in the multimap
     *
     * @return {@code true} if the multimap changed
     */
    long save(Iterable<? extends L> lefts, @Nonnull R right);

    /**
     * Copies all of another multimap's left-right pairs into this multimap. The
     * order in which the mappings are added is determined by
     * {@code multimap.entries()}.
     *
     * @param multimap mappings to store in this multimap
     * @return {@code true} if the multimap changed
     */
    long save(Multimap<? extends L, ? extends R> multimap);

    /**
     * Copies all of another multimap's right-left pairs into this multimap. The
     * order in which the mappings are added is determined by
     * {@code multimap.entries()}.
     *
     * @param multimap mappings to store in this multimap
     * @return {@code true} if the multimap changed
     */
    long saveInverse(Multimap<? extends R, ? extends L> inverseMultimap);

    /**
     * Stores a collection of rights with the same left, replacing any existing
     * rights for that left.
     *
     * @param key key to store in the multimap
     * @param rights rights to store in the multimap
     * @return Number of replaced rights.
     */
    @Nonnull long replaceRights(@Nonnull L left, Iterable<? extends R> rights);

    /**
     * Stores a collection of lefts with the same right, replacing any existing
     * lefts for that right.
     *
     * @param key key to store in the multimap
     * @param rights rights to store in the multimap
     */
    @Nonnull void replaceLefts(@Nonnull R right, Iterable<? extends L> lefts);

    // Views

    /**
     * Returns a multimap of all left-right pairs. It's the reverse of
     * {@link #save(Multimap)}.
     *
     * @return map entries
     */
    @Nonnull Multimap<L, R> findAll();

    /**
     * Returns a collection of all left-right pairs. Changes to the returned
     * collection will update the underlying multimap, and vice versa. The entries
     * collection does not support the {@code add} or {@code addAll} operations.
     *
     * @return collection of map entries consisting of left-right pairs
     */
    @Nonnull Collection<Map.Entry<L, R>> entries();

}
