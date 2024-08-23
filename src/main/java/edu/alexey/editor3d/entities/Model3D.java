package edu.alexey.editor3d.entities;

import java.util.ArrayList;
import java.util.Collection;

public class Model3D extends EntityBase {

	private final Collection<Texture> textures = new ArrayList<>();

	public Model3D() {
	}

	public Model3D(Collection<Texture> textures) {
		this.getTextures().addAll(textures);
	}

	public Collection<Texture> getTextures() {
		return textures;
	}

	@Override
	public String toString() {
		return String.format("3D-model #%d", super.getId());
	}

}
