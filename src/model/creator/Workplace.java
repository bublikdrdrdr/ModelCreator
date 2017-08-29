/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.creator;

import model.creator.graphics.ExampleModel;
import model.creator.graphics.GeometryAnimationManager;
import model.creator.graphics.Model;

/**
 *
 * @author Bublik
 */
public class Workplace extends Main{
    
    public static void main(String[] args) {
        new Workplace();
    }

    @Override
    public Model createModel() {
        //TODO: create model manager, return it in this method and run project to see result
        return new ExampleModel();
    }

    @Override
    public void runAnimation() {
        GeometryAnimationManager geometryAnimationManager = getGeometryAnimationManager();
        if (geometryAnimationManager!=null)
            //run your animation
            geometryAnimationManager.beginAnimation("build");
    }
    
    
    
}
