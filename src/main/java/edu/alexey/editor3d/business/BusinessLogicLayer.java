package edu.alexey.editor3d.business;

import java.util.Collection;

import edu.alexey.editor3d.entities.Model3D;
import edu.alexey.editor3d.entities.Texture;

/**
 * Интерфейс Business Logic Layer
 */
public interface BusinessLogicLayer {

	Collection<Model3D> getAllModels();

	Collection<Texture> getAllTextures();

	void renderModel(Model3D model);

	void renderAllModels();
}
