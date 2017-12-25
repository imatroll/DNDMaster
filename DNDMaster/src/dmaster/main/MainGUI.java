package dmaster.main;

import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.io.File;
import dmaster.gamerefs.*;

public class MainGUI {
	
	static ArrayList<Item> userItems = new ArrayList<Item>();
	
	static ArrayList<Monster> userMonsters = new ArrayList<Monster>();
	
	static ArrayList<File> userMaps = new ArrayList<File>();
	
	public static void main(String[] args) {
		
		JFrame gui = new JFrame("DNDMaster");
		gui.setLayout(new FlowLayout());
		
		JToolBar menu = new JToolBar();
		menu.setFloatable(false);
		
		JButton items = new JButton("Item Manager");
		menu.add(items);
		JButton monsters = new JButton("Monster Manager");
		menu.add(monsters);
		JButton maps = new JButton("Map Manager");
		menu.add(maps);
		JButton dice = new JButton("Dice Roll");
		menu.add(dice);
		gui.add(menu);
		
		items.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent event){
			JFrame itemDisplay = new JFrame("Items");
			itemDisplay.setLayout(new FlowLayout());
			
			JButton add = new JButton("Add Item");
			
			JTextArea display = new JTextArea(userItems.toString());
			display.setEditable(false);
			
			itemDisplay.add(add);
			itemDisplay.add(display);
			
			add.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent event){
				JFrame newItem = new JFrame("New Item");
				
				JTextArea name = new JTextArea("Enter the name your item here.");
				newItem.add(name);
				JComboBox<ItemTypes> type = new JComboBox<ItemTypes>(ItemTypes.values());
				newItem.add(type);
				
				JTextArea desc = new JTextArea("Enter the description of the item.");
				newItem.add(desc);
				
				JRadioButton held = new JRadioButton("The item is held.");
				JRadioButton worn = new JRadioButton("The item is worn.");
				newItem.add(worn);
				newItem.add(held);
				
				JCheckBox attune = new JCheckBox("Attunement required.");
				newItem.add(attune);
			}});
		}});
		
		monsters.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent event){
			JFrame monsterDisplay = new JFrame("Monsters");
			monsterDisplay.setLayout(new FlowLayout());
			
			JButton add = new JButton("Add Monster");
			
			JTextArea display = new JTextArea(userMonsters.toString());
			display.setEditable(false);
			
			monsterDisplay.add(add);
			monsterDisplay.add(display);
			
			add.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent event){
				JFrame newMonster = new JFrame("New Monster");
				JComboBox<Sizes> size = new JComboBox<Sizes>(Sizes.values());
				newMonster.add(size);
				JComboBox<MonsterTypes> type = new JComboBox<MonsterTypes>(MonsterTypes.values());
				newMonster.add(type);
				JComboBox<Alignment> alignment = new JComboBox<Alignment>(Alignment.values());
				newMonster.add(alignment);
				
			}});
		}});
		maps.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent event){
			JFrame mapDisplay = new JFrame("Maps");
			mapDisplay.setLayout(new FlowLayout());
			
			JButton add = new JButton("Add Map");
			
			JTextArea display = new JTextArea(userMaps.toString());
			display.setEditable(false);
			
			mapDisplay.add(add);
			mapDisplay.add(display);
		}});
		dice.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent event){
			JFrame input = new JFrame("Dice");
			input.setLayout(new FlowLayout());
			JTextArea in1 = new JTextArea("Please enter the number of dice here.");
			input.add(in1);
			JTextArea in2 = new JTextArea("Please enter the number of sides of each die here.");
			input.add(in2);
			JTextArea in3 = new JTextArea("Please enter the modifier here. Enter zero for no modifier");
			input.add(in3);
			
			JButton roll = new JButton("Roll Dice");
			input.add(roll);
			roll.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent event){
				String dice = in1.getText();
				int numDice = Integer.parseInt(dice);
				
				String sides = in2.getText();
				int numSides = Integer.parseInt(sides);
				
				String mod = in3.getText();
				int modTotal = Integer.parseInt(mod);
				
				Dice d = new Dice(numSides);
				
				String resultTotal = Integer.toString(d.rollMultModded(d, numDice, modTotal));
				
				JFrame result = new JFrame("Roll Result");
				result.setLayout(new FlowLayout());
				
				JTextArea resultDisplay = new JTextArea(resultTotal);
				
				result.add(resultDisplay);
			}});
		}});
	}

}
