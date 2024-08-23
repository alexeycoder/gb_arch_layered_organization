package edu.alexey.editor3d.dac;

import java.util.Collection;

import edu.alexey.editor3d.entities.Entity;
import edu.alexey.editor3d.entities.Model3D;
import edu.alexey.editor3d.entities.Texture;

/**
 * Интерфейс Data Access Component
 */
public interface DatabaseAccess {

	void addEntity(Entity entity);

	void removeEntity(Entity entity);

	Collection<Texture> getAllTextures();

	Collection<Model3D> getAllModels();
}
