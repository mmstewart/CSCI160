/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects;

import Controller.KeyboardController;
import Interfaces.Moveable;
import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author Marcus Stewart
 */
public abstract class ControlledGameObject extends GameObject implements Moveable
{
    public ControlledGameObject(int xPosition, int yPosition, KeyboardController control, BufferedImage bi) {
        super(xPosition, yPosition, bi, control);
    }
    
    public ControlledGameObject(int xPosition, int yPosition, BufferedImage bi, KeyboardController control)
    {
        super(xPosition, yPosition, bi, control);
    }
}