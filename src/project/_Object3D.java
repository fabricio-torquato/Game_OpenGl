/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import com.sun.opengl.util.GLUT;
import javax.media.opengl.GL;

/**
 *
 * @author fabricio
 */
public interface _Object3D {
    
    
    void Draw(GL gl, GLUT glut, double glTranslated, int glRotated);
    
    void Draw(GL gl, GLUT glut,int glRotated);

}
