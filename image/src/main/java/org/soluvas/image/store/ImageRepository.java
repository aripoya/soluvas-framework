package org.soluvas.image.store;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.soluvas.commons.ProgressMonitor;
import org.soluvas.data.EntityLookup;
import org.soluvas.data.repository.PagingAndSortingRepository;
import org.soluvas.image.ImageConnector;
import org.soluvas.image.TransformGravity;

/**
 * @todo extend {@link EntityLookup}. However, namespace needs to be changed, e.g. image_person, otherwise REAL 'person' repo/lookup will conflict with IMAGE 'person' repo/lookup. 
 * @todo extend {@link PagingAndSortingRepository}
 * @author ceefour
 */
//TODO: extend EntityLookup
// TODO: extend PagingAndSortingRepository
public interface ImageRepository { // extends EntityLookup<Image, String> {

	/**
	 * Name of the predefined "original" image style.
	 */
	public static String ORIGINAL_NAME = "original";
	/**
	 * Short code for predefined "original" image style.
	 */
	public static String ORIGINAL_CODE = "o";

	/**
	 * Ensure folders exists based on namespace and image styles.
	 * @todo Implement
	 */
	public abstract void createFolders();

	/**
	 * Note that the shortCode 'o' (for "original") is reserved.
	 * @param name
	 * @param code
	 * @param maxWidth
	 * @param maxHeight
	 * @deprecated Use setStyles(). This doesn't support {@link TransformGravity}.
	 */
	@Deprecated
	public abstract void addStyle(String name, String code, int maxWidth,
			int maxHeight);

	public abstract List<ImageStyle> getStyles();

	/**
	 * Note that the shortCode 'o' (for "original") is reserved.
	 * 
	 * This does not use the styles, but rather copy it to our own.
	 * 
	 * @param styles Source styles that will be copied.
	 */
	public abstract void setStyles(List<ImageStyle> styles);

	/**
	 * Scheme: ${publicUri}/${namespace}/${shortCode}/${id}_${shortCode}.${extension}
	 * @return
	 */
	public abstract String getImageUri(String id, String styleName);

	/**
	 * Add an {@link Image} from an {@link InputStream}. This method makes use of a temporary file.
	 * @deprecated Better use {@link MongoImageRepository#add(Image)}.
	 * @param fileName
	 * @param content
	 * @param contentType
	 * @param length
	 * @param name
	 * @return
	 * @throws IOException
	 */
	@Deprecated
	public abstract String create(String fileName, InputStream content,
			String contentType, long length, String name) throws IOException;

	/**
	 * Upload a file.
	 * 
	 * Note: To comply with Soluvas Data, the add() method should accept a VO object (that can be deserialized from
	 * JSON, AMQP, RDF, XMI, etc.). See add().
	 * @param imageId If provided, will use the imageId (possibly overwrite image with same ID). If not provided, will generate a new image ID.
	 * @param originalFile
	 * @param contentType
	 * @param name
	 * 
	 * @return
	 * @throws IOException
	 */
	public abstract String create(String imageId, File originalFile,
			String contentType, String name) throws IOException;

	/**
	 * Upload a file.
	 * 
	 * To comply with Soluvas Data, the add() method should accept a VO object (that can be deserialized from
	 * JSON, AMQP, RDF, XMI, etc.). All exceptions are rethrown as runtime exceptions.
	 * 
	 * Required attributes for new {@link Image} are: originalFile, contentType, name.
	 * 
	 * If {@literal id} attribute is provided, will use it (possibly overwrite image with same ID).
	 * If not provided, will generate a new image ID.
	 * 
	 * @param newImage
	 * @return
	 */
	public abstract String add(Image newImage);
	public abstract List<String> add(@Nonnull List<Image> newImages, ProgressMonitor monitor);

	public abstract String doCreate(String existingImageId, File originalFile,
			String contentType, long length, String name, String originalName,
			boolean alsoUploadOriginal) throws IOException;

	/**
	 * Delete the image with the specified ID, from the MongoDB metadata including all files and styled images from WebDAV.
	 * @param id Image ID.
	 * @return TODO
	 */
	public abstract boolean delete(String id);
	
	/**
	 * Delete multiple images with the specified ID, from the MongoDB metadata including all files and styled images from WebDAV.
	 * @param id Image IDs.
	 */
	public abstract void deleteMultiple(Set<String> ids);

	public abstract Image findOne(@Nullable String id);

	public abstract Map<String, Image> findAllByIds(Iterable<String> ids);

	/**
	 * List all {@link Image}s, ordered by Image ID.
	 * @return
	 */
	public abstract List<Image> findAll();
	
	/**
	 * List all {@link Image} IDs (sorted).
	 * @return
	 */
	public abstract List<String> findAllIds();

	/**
	 * Search {@link Image}s by ID, fileName, URL. Sorted by ID.
	 * @return
	 */
	public abstract List<Image> search(String searchText);

	/**
	 * For each image, redownloads the original file from WebDAV repository, reprocesses each image style, and re-uploads the processed images to WebDAV repository.
	 * @param ids
	 */
	public abstract void reprocess(Iterable<String> ids, ProgressMonitor pm);

	public abstract void reprocessAll(ProgressMonitor pm);

	public abstract String getNamespace();

	public abstract String getMongoUri();

	/**
	 * Note: For now Akka is not used, but for backwards compatibility it is simply ignored.
	 * @param system the Akka actor system to set
	 */
	//	public void setSystem(ActorSystem system) {
	//		this.system = system;
	//	}
	public abstract void setSystem(Object system);

	public abstract void updateUriAll(ProgressMonitor monitor);

	public abstract void updateUri(Collection<String> imageIds, ProgressMonitor monitor);
	
	public String getUriTemplate();
	
	public ImageConnector getConnector();
	
	public abstract boolean exists(String id);

}
