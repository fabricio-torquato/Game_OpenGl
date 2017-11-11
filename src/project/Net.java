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
public class Net extends Player {

    public Net(double x, double y) {
        super(x);
        setX(x);
        setY(y);
    }

    @Override
    public void Draw(GL gl, GLUT glut, double glTranslated, int glRotated) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Draw(GL gl, GLUT glut, int glRotated) {
        gl.glPushMatrix();
        gl.glPushMatrix();
        gl.glColor3f(1, 1, 1);
        gl.glRotated(90, 1, 0, 0);
        gl.glTranslated(this.getX(), this.getY() + 2, -1.7f);
        glut.glutSolidCylinder(0.2f, 4, 16, 16);
        gl.glPopMatrix();
        gl.glPushMatrix();
        gl.glColor3f(1, 1, 1);
        gl.glRotated(90, 1, 0, 0);
        gl.glTranslated(this.getX(), this.getY() - 2, -2);
        glut.glutSolidCylinder(0.2f, 4, 16, 16);
        gl.glPopMatrix();
        gl.glColor3f(0.9f, 0.9f, 0.98f);
        gl.glTranslated(this.getX(), this.getY() + 0.5f, 0);
        gl.glScaled(0.4f, 1.8f, 4);
        gl.glRotated(glRotated, 0, 1, 0);
        glut.glutSolidCube(1);

        gl.glPopMatrix();
    }
}
