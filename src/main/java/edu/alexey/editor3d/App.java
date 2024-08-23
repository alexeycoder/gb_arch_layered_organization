package edu.alexey.editor3d;

import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.alexey.editor3d.ui.Editor3D;

/**
 * Необходимо разделить на горизонтальные уровни "Редактор 3D графики". Один
 * пользователь. Программа работает на одном ПК без выхода в сеть.
 * 
 * Что видит пользователь, как взаимодействует? (Панель загрузки, блок
 * редактирования, блок просмотра). Какие задачи можно делать — функции системы?
 * (Загрузить 3D модель, рассмотреть 3D модель, создать новую, редактировать
 * вершины, текстуры, сделать рендер, сохранить рендер). Какие и где храняться
 * данные? (Файлы 3D моделей, рендеры, анимация,.. в ФС компьютера).
 * 
 * Предложить варианты связывания всех уровней — сценарии использования.
 * Сквозная функция — создать новую 3D модель, сделать рендер для печати на
 * принтере...
 */
public class App {

	static final Scanner SCANNER = new Scanner(System.in);

	public static void main(String[] args) {

		Editor3D editor3d = new Editor3D();

		while (true) {

			printMenu();

			if (SCANNER.hasNextInt()) {

				int choice = SCANNER.nextInt();
				SCANNER.nextLine();

				boolean doContinue = performTask(editor3d, choice);
				if (!doContinue) {
					return;
				}
			}
		}
	}

	private static void printMenu() {

		System.out.println();
		System.out.println("*** 3D Редактор ***");
		System.out.println();
		System.out.println("Меню Проекта");
		System.out.println("1. Открыть проект");
		System.out.println("2. Сохранить проект");
		System.out.println("3. Показать парамеры");
		System.out.println("4. Список моделей");
		System.out.println("5. Список текстур");
		System.out.println("6. Визуализировать все модели");
		System.out.println("7. Визуализировать одну модель");
		System.out.println("0. Завершить работу");
		System.out.println();
		System.out.print("Выберите пункт меню: ");
	}

	private static boolean performTask(Editor3D editor3d, int key) {

		System.out.println();

		switch (key) {
		case 0: {
			System.out.println("Завершение работы приложения");
			return false;
		}
		case 1: {
			System.out.println("Введите имя файла проекта: ");
			String filename = SCANNER.nextLine();
			editor3d.openProject(filename);
			return true;
		}
		case 2: {
			editor3d.saveProject();
			return true;
		}
		case 3: {
			editor3d.showProjectSettings();
			return true;
		}
		case 4: {
			editor3d.printAllModels();
			return true;
		}
		case 5: {
			editor3d.printAllTextures();
			return true;
		}
		case 6: {
			editor3d.renderAll();
			return true;
		}
		case 7: {
			System.out.println("Введите номер модели по списку, начиная с 1: ");
			int num = SCANNER.nextInt();
			SCANNER.nextLine();
			editor3d.renderModel(num);
			return true;
		}
		default:
			throw new NoSuchElementException("key");
		}
	}
}
