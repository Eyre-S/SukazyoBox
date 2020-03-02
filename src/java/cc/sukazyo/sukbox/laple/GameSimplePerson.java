package cc.sukazyo.sukbox.laple;

import javafx.beans.InvalidationListener;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class GameSimplePerson {
	
	public SimpleDoubleProperty health = new SimpleDoubleProperty(1);
	public SimpleDoubleProperty temperature = new SimpleDoubleProperty(36.5);
	public SimpleDoubleProperty bloody = new SimpleDoubleProperty(0);
	public SimpleDoubleProperty hunger = new SimpleDoubleProperty(0.6);
	public SimpleDoubleProperty water = new SimpleDoubleProperty(0.9);
	public SimpleDoubleProperty clean = new SimpleDoubleProperty(0.75);
	public SimpleDoubleProperty power = new SimpleDoubleProperty(1);
	public SimpleDoubleProperty mood = new SimpleDoubleProperty(0.88);
	
}
