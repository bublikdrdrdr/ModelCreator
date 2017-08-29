package model.creator;

import com.jme3.app.SimpleApplication;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.math.ColorRGBA;
import com.jme3.renderer.RenderManager;
import com.jme3.system.AppSettings;
import model.creator.graphics.GeometryAnimationManager;
import model.creator.graphics.GeometryManager;
import model.creator.graphics.Model;
import model.creator.utils.StaticAssetManager;

/**
 * test
 * @author Bublik
 */
//DO NOT TOUCH! GO TO WORKPLACE CLASS!
public class Main extends SimpleApplication {

    GeometryAnimationManager geometryAnimationManager;
    
    public Main(){
        init();
        start();
    }
    
    private void init(){
        this.setShowSettings(Settings.showSettings);
        this.setDisplayFps(Settings.showDetails);
        this.setDisplayStatView(Settings.showDetails);
        AppSettings cfg = new AppSettings(true);
        cfg.setFrameRate(60); 
        cfg.setVSync(true);  
        cfg.setFrequency(60); 
        cfg.setResolution(1024, 768);   
        cfg.setFullscreen(false); 
        cfg.setSamples(16);
        cfg.setTitle("Redivansion model creator by bublik.drdrdr");
        this.setSettings(cfg);
    }
    
    public Model createModel(){
        return null;
    }
    
    public GeometryAnimationManager getGeometryAnimationManager(){
        return geometryAnimationManager;
    }
    
    public void runAnimation(){
        
    }

    @Override
    public void simpleInitApp() {
        StaticAssetManager.setAssetManager(assetManager);
        flyCam.setMoveSpeed(Settings.cameraMoveSpeed);
        AmbientLight allLight = new AmbientLight();
        allLight.setColor(ColorRGBA.DarkGray);
        rootNode.addLight(allLight);
        DirectionalLight light = new DirectionalLight();
        light.setDirection(getCamera().getDirection());
        rootNode.addLight(light);
        Model model = createModel();
        if (model!=null){
            geometryAnimationManager = new GeometryAnimationManager(model);
            rootNode.attachChild(geometryAnimationManager);
        }
        runAnimation();
    }

    @Override
    public void simpleUpdate(float tpf) {
        geometryAnimationManager.onUpdate();
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
