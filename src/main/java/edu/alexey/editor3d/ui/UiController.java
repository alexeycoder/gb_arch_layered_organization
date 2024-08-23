package edu.alexey.editor3d.ui;

/**
 * Интерфейс UI
 */
public interface UiController {

	void openProject(String filename);

	void showProjectSettings();

	void saveProject();

	void printAllModels();

	void printAllTextures();

	void renderAll();

	/**
	 * Операция визуализации модели по её порядковому номеру.
	 * 
	 * @param i порядковый номер по списку, начиная с 1.
	 */
	void renderModel(int i);
}
