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
public class Ball implements _Object3D {

    private double x;
    private double y;
    private double size;
    private boolean flagX;
    private boolean flagY;

    Ball(double x, double y, double size) {
        this.x = x;
        this.y = y;
        this.flagX = true;
        this.flagY = true;
        this.size = size;
    }

    public void Draw(GL gl, GLUT glut, int glRotated) {
        gl.glPushMatrix();
        gl.glColor3f(1, 1, 1);
        gl.glTranslated(x, y, 0);
        gl.glScaled(2, 2, 2);
        gl.glRotated(glRotated, 0, 1, 0);
        glut.glutSolidSphere(this.getSize(), 16, 16);
        gl.glPopMatrix();
        gl.glPushMatrix();
        gl.glColor3f(0, 0, 0);
        gl.glTranslated(x, y, 0);
        gl.glScaled(2, 2, 2);
        gl.glRotated(glRotated, 0, 1, 0);
        glut.glutWireSphere(this.getSize(), 10, 10);
        gl.glPopMatrix();
    }

    public int move(Player player1, Player player2, Net net) {
        boolean intersect = false;
        intersect = isIntersect(player1);
        if (!intersect) {
            intersect = isIntersect(player2);
        }
        if (!intersect) {
            intersect = isIntersect(net);
        }

        if (this.getX() < -5) {
            this.flagX = true;
        } else if (this.getX() > 7) {
            this.flagX = false;
        }
        if (this.getY() < 0) {
            this.flagY = true;
        } else if (this.getY() > 5) {
            this.flagY = false;
        }
        if (intersect) {
            this.flagX = !this.flagX;
            this.flagY = !this.flagY;
        }
        if (this.flagX) {
            this.setX(this.getX() + 0.2);
        } else {
            this.setX(this.getX() - 0.2);
        }
        if (this.flagY) {
            this.setY(this.getY() + 0.2);
        } else {
            this.setY(this.getY() - 0.2);
        }
        if (intersect) {
            return 1;
        }
        return 0;
    }

    private boolean isIntersect(Player player) {
        return (this.getX() + this.getSize() > player.getX() && this.getX() < player.getX() + player.getSize_x() && this.getY() + this.getSize() > 0 && this.getY() + this.getSize() < 1 + player.getSize_y());
    }

    public int isDeadBall() {
        if (this.getY() <= 0 && this.getX() <= 0) {
            return 1;
        }
        if (this.getY() <= 0 && this.getX() > 0) {
            return 2;
        }
        return 0;
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

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void Draw(GL gl, GLUT glut, double glTranslated, int glRotated) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
