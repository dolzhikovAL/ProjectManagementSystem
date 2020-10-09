package com.project.management.console;

public class Controller {

    private View view;

    public Controller(View view){
        this.view=view;
    }

    public void readOption(){
        view.write("Hello world \n" +
                "This is Project management system \n" +
                "Please tape one of the next command \n" +
                "" );
    }

}
