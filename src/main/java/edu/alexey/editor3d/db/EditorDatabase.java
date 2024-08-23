package edu.alexey.editor3d.db;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;

import edu.alexey.editor3d.entities.Entity;
import edu.alexey.editor3d.entities.Model3D;
import edu.alexey.editor3d.entities.ProjectFile;
import edu.alexey.editor3d.entities.Texture;

/**
 * Компонент Database
 */
public class EditorDatabase implements Database {

	private final ProjectFile projectFile;
	private Collection<Entity> entities;

	public EditorDatabase(ProjectFile projectFile) {
		this.projectFile = projectFile;
		load();
	}

	@Override
	public void load() {
		// TODO Загрузка всех сущностей проекта (модели, текстуры,...)
	}

	@Override
	public void save() {
		// TODO Сохранение текущего состояния всех сущностей проекта
	}

	@Override
	public Collection<Entity> getAll() {

		// lazy init
		if (entities == null) {
			var entityList = new ArrayList<Entity>();

			int n = ThreadLocalRandom.current().nextInt(5, 11);
			for (int i = 0; i < n; ++i) {
				generateAndPushModelWithTextures(entityList);
			}

			entities = entityList;
		}

		return entities;
	}

	private static void generateAndPushModelWithTextures(ArrayList<Entity> entityList) {

		var textures = new ArrayList<Texture>();
		int n = ThreadLocalRandom.current().nextInt(4);
		for (int i = 0; i < n; ++i) {
			textures.add(new Texture());
		}

		Model3D model = new Model3D(textures);

		entityList.addAll(textures);
		entityList.add(model);
	}

}
