package com.superdzen.javapro.Delegate;

/**
 * Created by superdzen@gmail.com on 28.05.2018.
 * https://youtu.be/qfKX4xQ4Yos
 */
public class DelegateApp {
    public static void main(String[] args) {
        Painter painter = new Painter();

        painter.setFigure(new Circle());
        painter.draw();

        painter.setFigure(new Square());
        painter.draw();

        painter.setFigure(new Triange());
        painter.draw();
    }
}


interface Figure {
    void draw();
}

class Circle implements Figure {

    @Override
    public void draw() {
        System.out.println("Draw a circle");
    }
}

class Square implements Figure {

    @Override
    public void draw() {
        System.out.println("Draw a square");
    }
}

class Triange implements Figure {

    @Override
    public void draw() {
        System.out.println("Draw a triangle");
    }
}

class Painter {
    private Figure figure;

    void setFigure(Figure f) {
        figure = f;
    }

    void draw() {
        figure.draw();
    }
}
