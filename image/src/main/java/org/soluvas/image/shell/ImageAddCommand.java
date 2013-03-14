 package org.soluvas.image.shell; 

import java.io.File;
import java.net.URL;

import javax.annotation.Nullable;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.tenant.ServiceLookup;
import org.soluvas.image.store.Image;
import org.soluvas.image.store.ImageRepository;

import com.google.common.base.Function;
import com.google.common.base.Optional;

/**
 * Shell command to search {@link org.soluvas.image.store.Image} entities.
 *
 * Image class is used to hold the metadata of images in the Soluvas Image Store.
 *
 * @author ceefour
 */
@Command(scope="image", name="add", description="Add a new Image entity.")
public class ImageAddCommand extends OsgiCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(ImageAddCommand.class);

	private ServiceLookup svcLookup;
	@Option(name="-n", aliases={"--ns", "--namespace"},
		description="Namespace, e.g. person, shop, product. Default is 'person'.")
	private String namespace;

	@Argument(index=0, name="originalFile", required=true,
		description="File or URL to upload.")
	private String originalFile;
	@Argument(index=1, name="contentType", required=false,
		description="Content type, e.g. image/jpeg.")
	private String contentType = "image/jpeg";
	@Argument(index=2, name="name", required=false,
		description="Short descriptive name. Default: (base filename).")
	private String name;


	public ImageAddCommand(ServiceLookup svcLookup) {
		super();
		this.svcLookup = svcLookup;
	}

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		final Image newImage = new Image();
		final File tmpFile = File.createTempFile("imageadd_", ".jpg");
		try {
			if (originalFile != null)
				if (originalFile.matches("[a-z]{2,}:.*")) {
					log.info("Downloading {} to {} for adding image", originalFile, tmpFile);
					URL url = new URL(originalFile);
					FileUtils.copyURLToFile(url, tmpFile);
					newImage.setOriginalFile(tmpFile);
				} else {
					newImage.setOriginalFile(new File(originalFile));
				}
			if (contentType != null)
				newImage.setContentType(contentType);
			if (name != null) {
				newImage.setName(name);
			} else {
				newImage.setName( FilenameUtils.getBaseName(originalFile) );
			}

			final String realNamespace = Optional.fromNullable(namespace).or("person");
			return svcLookup.withService(ImageRepository.class, session, realNamespace,
				new Function<ImageRepository, Object>() {
					@Override @Nullable public Object apply(@Nullable ImageRepository imageStore) {
						String addedImageId = imageStore.add(newImage);
						return addedImageId;
					}
				});
		} finally {
			tmpFile.delete();
		}
	}

}