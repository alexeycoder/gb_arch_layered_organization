package edu.alexey.editor3d.entities;

public abstract class EntityBase implements Entity {

	private static int counter = -1;

	private int id;

	{
		id = ++counter;
	}

	@Override
	public int getId() {
		return id;
	}

}
