/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.creator;

import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import model.creator.graphics.ExampleModel;
import model.creator.graphics.GeometryAnimationManager;
import model.creator.graphics.Model;
import model.creator.graphics.PolyAnimation;
import model.creator.graphics.Polygon;
import model.creator.models.FinalTree;
import model.creator.models.HouseModel;
import model.creator.models.PowerplantModel;
import model.creator.models.SimpleModel;
import model.creator.models.TerrainModel;
import model.creator.models.TreeModel;
import model.creator.models.RoadModel;

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
        Model model = new FinalTree();
        saveFile(model);
        return model;
    }

    @Override
    public void runAnimation() {
        runAnimationAfter("build", 0);
        runAnimationAfter("destroy", 2000);
        //runAnimationAfter("buildTurn", 0);
        //runAnimationAfter("destroyLone", 2000);
        //runAnimationAfter("buildStraight", 1000);
        /*runAnimationAfter("destroyStraight", 2000);
        runAnimationAfter("buildEnd", 1000);
        runAnimationAfter("destroyEnd", 2000);
        runAnimationAfter("buildTurn", 1000);
        runAnimationAfter("destroyTurn", 2000);
        runAnimationAfter("buildTriple", 1000);
        runAnimationAfter("destroyTriple", 2000);
        runAnimationAfter("buildQuadriple", 1000);
        runAnimationAfter("destroyQuadriple", 2000);
        runAnimationAfter("stage1", 9000);
        runAnimationAfter("stage2", 10000);
        runAnimationAfter("stage1", 11000);
        runAnimationAfter("stage2", 12000);
        runAnimationAfter("stage1", 13000);
        runAnimationAfter("stage2", 14000);
        runAnimationAfter("stage1", 15000);
        runAnimationAfter("stage2", 16000);*/
        
        /*runAnimationAfter("build", 0);
        runAnimationAfter("stage1", 9000);
        runAnimationAfter("destroy2", 10000);*/
        /*runAnimationAfter("build_lvl_1", 0);
        runAnimationAfter("upgrade_lvl_2", 2000);
        runAnimationAfter("downgrade_lvl_1", 4000);
        runAnimationAfter("upgrade_lvl_2", 6000);
        runAnimationAfter("destroy_lvl_2", 8000);*/
    }
    
    
    
}
