package edu.alexey.editor3d.ui;

import java.util.Collection;

import edu.alexey.editor3d.business.BusinessLogicLayer;
import edu.alexey.editor3d.business.EditorBusinessLogicLayer;
import edu.alexey.editor3d.dac.DatabaseAccess;
import edu.alexey.editor3d.dac.EditorDatabaseAccess;
import edu.alexey.editor3d.db.Database;
import edu.alexey.editor3d.db.EditorDatabase;
import edu.alexey.editor3d.entities.Model3D;
import edu.alexey.editor3d.entities.ProjectFile;
import edu.alexey.editor3d.entities.Texture;

public class Editor3D implements UiLayer {

	private Database database;
	private DatabaseAccess databaseAccess;
	private BusinessLogicLayer businessLogic;
	private ProjectFile projectFile;

	public Editor3D() {
	}

	@Override
	public void openProject(String filename) {

		projectFile = new ProjectFile(filename);
		initialize();
		System.out.println("Проект успешно загружен");
	}

	private void initialize() {
		database = new EditorDatabase(projectFile);
		databaseAccess = new EditorDatabaseAccess(database);
		businessLogic = new EditorBusinessLogicLayer(databaseAccess);
	}

	@Override
	public void showProjectSettings() {

		// Предусловие
		if (!checkProjectFile()) {
			return;
		}

		System.out.println("*** Проект ***");
		System.out.println("**************");
		System.out.printf("filename: %s", projectFile.getFilename());
		System.out.printf("setting1: %d%n", projectFile.getSetting1());
		System.out.printf("setting2: %s%n", projectFile.getSetting2());
		System.out.printf("setting3: %s%n", projectFile.getSetting3());
		System.out.println("**************");

	}

	@Override
	public void saveProject() {

		// Предусловие
		if (!checkProjectFile()) {
			return;
		}

		database.save();
		System.out.println("Проект успешно сохранён");
	}

	@Override
	public void printAllModels() {

		// Предусловие
		if (!checkProjectFile()) {
			return;
		}

		Collection<Model3D> models = businessLogic.getAllModels();

		if (models.isEmpty()) {
			System.out.println("Проект пока ещё не содержит моделей.");
			return;
		}

		int lineNum = 0;
		for (Model3D model : models) {
			System.out.printf("%d:\tМодель ID=%d%n", ++lineNum, model.getId());
			System.out.println("   \tТекстуры модели:");

			Collection<Texture> textures = model.getTextures();

			if (textures.isEmpty()) {
				System.out.println("   \t\tНе заданы");
				continue;
			}

			for (Texture texture : textures) {
				System.out.printf("   \t\tТекстура ID=%d%n", texture.getId());
			}
		}
	}

	@Override
	public void printAllTextures() {

		// Предусловие
		if (!checkProjectFile()) {
			return;
		}

		Collection<Texture> textures = businessLogic.getAllTextures();

		if (textures.isEmpty()) {
			System.out.println("Проект пока ещё не содержит текстур");
			return;
		}

		int lineNum = 0;
		for (Texture texture : textures) {
			System.out.printf("%d:\tТекстура ID=%d%n", ++lineNum, texture.getId());
		}
	}

	@Override
	public void renderAll() {

		// Предусловие
		if (!checkProjectFile()) {
			return;
		}

		System.out.println("Визуализация. Ожидайте...");
		long startTime = System.currentTimeMillis();
		businessLogic.renderAllModels();
		long duration = System.currentTimeMillis() - startTime;
		System.out.printf("Операция выполнена за %d мс.%n", duration);
	}

	@Override
	public void renderModel(int i) {

		// Предусловие
		if (!checkProjectFile()) {
			return;
		}

		Collection<Model3D> models = businessLogic.getAllModels();

		if (i <= 0 || i > models.size()) {
			System.out.println("Номер модели указан некорректно.");
			return;
		}

		var model = models.stream().skip(i - 1).limit(1).findAny().get();

		System.out.println("Визуализация модели. Ожидайте...");
		long startTime = System.currentTimeMillis();
		businessLogic.renderModel(model);
		long duration = System.currentTimeMillis() - startTime;
		System.out.printf("Операция выполнена за %d мс.%n", duration);
	}

	private boolean checkProjectFile() {
		if (projectFile == null) {
			System.out.println("Рабочий проект не определён."
					+ " Необходимо открыть или создать новый проект.");
			return false;
		}
		return true;
	}
}
