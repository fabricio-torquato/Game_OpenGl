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
public class Player implements _Object3D {

    private double x;
    private double y;
    private double size_x;
    private double size_y;
    private double size_z;

    public Player(double x) {
        this.x = x;
        this.y = 0.0f;
        this.size_x = 0.8;
        this.size_y = 1;
        this.size_z = 1;
    }

    public void Draw(GL gl, GLUT glut, double glTranslated, int glRotated) {
        this.setX(this.getX() + glTranslated);

        gl.glPushMatrix();
        gl.glPushMatrix();
        gl.glColor3f(0, 0, 1);
        gl.glRotated(90, 1, 0, 0);
        gl.glTranslated(this.getX(), 0.25f, 0);
        glut.glutSolidCylinder(0.15f, 1, 16, 16);
        gl.glPopMatrix();
        gl.glPushMatrix();
        gl.glColor3f(0, 0, 1);
        gl.glRotated(90, 1, 0, 0);
        gl.glTranslated(this.getX(), -0.4f, 0);
        glut.glutSolidCylinder(0.15f, 1, 16, 16);
        gl.glPopMatrix();
        gl.glPushMatrix();
        gl.glColor3f(1, 0, 0);
        gl.glTranslated(this.getX(), 0.2f, 0);
        gl.glScaled(getSize_x(), getSize_y()/2, getSize_z());
        glut.glutSolidCube(1);
        gl.glPopMatrix();
        gl.glColor3f(0, 1, 1);
        gl.glTranslated(this.getX(), 0.95f, 0);
        gl.glScaled(getSize_x(), getSize_y()/2+0.5f, getSize_z());
        glut.glutSolidCube(1);

        gl.glPopMatrix();
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getSize_x() {
        return size_x;
    }

    public void setSize_x(double size_x) {
        this.size_x = size_x;
    }

    public double getSize_y() {
        return size_y;
    }

    public void setSize_y(double size_y) {
        this.size_y = size_y;
    }

    public double getSize_z() {
        return size_z;
    }

    public void setSize_z(double size_z) {
        this.size_z = size_z;
    }

    public void Draw(GL gl, GLUT glut, int glRotated) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
