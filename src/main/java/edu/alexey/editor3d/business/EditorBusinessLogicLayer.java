package edu.alexey.editor3d.business;

import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;

import edu.alexey.editor3d.dac.DatabaseAccess;
import edu.alexey.editor3d.entities.Model3D;
import edu.alexey.editor3d.entities.Texture;

/**
 * Реализация Business Logic Layer
 */
public class EditorBusinessLogicLayer implements BusinessLogicLayer {

	private final DatabaseAccess databaseAccess;

	public EditorBusinessLogicLayer(DatabaseAccess databaseAccess) {
		this.databaseAccess = databaseAccess;
	}

	@Override
	public Collection<Model3D> getAllModels() {
		return databaseAccess.getAllModels();
	}

	@Override
	public Collection<Texture> getAllTextures() {
		return databaseAccess.getAllTextures();
	}

	@Override
	public void renderModel(Model3D model) {

		render(model);
	}

	@Override
	public void renderAllModels() {

		for (var model : getAllModels()) {
			renderModel(model);
		}
	}

	private void render(Model3D model) {

		try {
			Thread.sleep(2500 - ThreadLocalRandom.current().nextInt(2000));
			System.out.println(model.toString());
			for (Texture texture : model.getTextures()) {
				System.out.println("\t" + texture.toString());
			}
			System.out.println();

		} catch (InterruptedException e) {
			System.out.println("Визуализация прервана.");
		}
	}

}
