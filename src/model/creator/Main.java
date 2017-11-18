package model.creator;

import com.jme3.app.SimpleApplication;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.post.FilterPostProcessor;
import com.jme3.post.filters.CartoonEdgeFilter;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.debug.Grid;
import com.jme3.system.AppSettings;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Callable;
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
        cfg.setVSync(Settings.vSynch);  
        //cfg.setFrequency(60); 
        cfg.setResolution(1024, 768);   
        cfg.setFullscreen(false); 
        cfg.setSamples(16);
        cfg.setTitle("Redivansion model creator by bublik.drdrdr");
        this.setSettings(cfg);
    }
    
    private void attachGrid(Vector3f pos, int size, ColorRGBA color){
        Geometry g = new Geometry("wireframe grid", new Grid(size, size, 0.5f) );
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.getAdditionalRenderState().setWireframe(true);
        mat.setColor("Color", color);
        g.setMaterial(mat);
        g.center().move(pos);
        rootNode.attachChild(g);
    }
    
    public Model createModel(){
        return null;
    }
    
    public GeometryAnimationManager getGeometryAnimationManager(){
        return geometryAnimationManager;
    }
    
    public void runAnimation(){
        
    }
    
    private void setToonShader(){
        viewPort.setBackgroundColor(ColorRGBA.Blue);
        FilterPostProcessor fpp=new FilterPostProcessor(assetManager);
        fpp.addFilter(new CartoonEdgeFilter());
        viewPort.addProcessor(fpp);
    }

    private DirectionalLight light;
    @Override
    public void simpleInitApp() {
        attachGrid(Vector3f.ZERO, 100, ColorRGBA.Blue);
        if (Settings.useToonShader) setToonShader();
        StaticAssetManager.setAssetManager(assetManager);
        flyCam.setMoveSpeed(Settings.cameraMoveSpeed);
        cam.setLocation(new Vector3f(10,20,10));
        cam.lookAt(Vector3f.ZERO, Vector3f.UNIT_Y);
        AmbientLight allLight = new AmbientLight();
        allLight.setColor(ColorRGBA.Gray);
        rootNode.addLight(allLight);
        light = new DirectionalLight();
        light.setColor(ColorRGBA.White.mult(1f));
        light.setDirection(getCamera().getDirection());
        rootNode.addLight(light);
        Model model = createModel();
        if (model!=null){
            geometryAnimationManager = new GeometryAnimationManager(model);
            rootNode.attachChild(geometryAnimationManager);
        }
        /*cam.setParallelProjection(false);
        float aspect = 1.77777f;
        float size   = 2f;
        cam.setFrustum(1f, 1000, -aspect * size, aspect * size, size, -size);
        cam.setLocation(new Vector3f(10,10,10));*/
        runAnimation();
    }

    @Override
    public void simpleUpdate(float tpf) {
        light.setDirection(cam.getDirection());
        geometryAnimationManager.onUpdate();
        if (Settings.rotateModel)
        geometryAnimationManager.rotate(0, tpf/4, 0);
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
    
    protected void runAnimationAfter(final String animationName, final long delay){
        Thread thread = new Thread(new Runnable() {
            public void run() {
                try{
                    Thread.sleep(delay);
                    enqueue(new Callable<Integer>() {

                        public Integer call() throws Exception {
                            geometryAnimationManager.beginAnimation(animationName);
                            return 1;
                        }
                    });
                } catch (Exception e){
                    
                }
            }
        });
        thread.start();
    }
    
    protected void saveFile(Model model){
        try{
            File file = new File("model.crm");
                FileOutputStream fos = new FileOutputStream(file);
                fos.write(model.getBytes());
                fos.close();
        } catch (IOException e){
            System.err.println("Can't save file");
        }
    }
}
