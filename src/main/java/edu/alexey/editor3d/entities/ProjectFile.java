package edu.alexey.editor3d.entities;

/**
 * Файл проекта
 */
public class ProjectFile {

	private String filename;

	private int setting1;

	private String setting2;

	private boolean setting3;

	public ProjectFile(String filename) {
		this.filename = filename;
		loadSettings();
	}

	public String getFilename() {
		return filename;
	}

	public int getSetting1() {
		return setting1;
	}

	public String getSetting2() {
		return setting2;
	}

	public boolean getSetting3() {
		return setting3;
	}

	private void loadSettings() {
		setting1 = 1;
		setting2 = "2";
		setting3 = false;
	}
}
