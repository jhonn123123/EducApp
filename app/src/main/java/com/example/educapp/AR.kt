package com.example.educapp

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.ar.core.*
import com.google.ar.core.exceptions.*
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.FrameTime
import com.google.ar.sceneform.Scene
import com.google.ar.sceneform.rendering.ModelRenderable
import kotlinx.android.synthetic.main.activity_a_r.*
import java.io.IOException


class AR : AppCompatActivity(), Scene.OnUpdateListener {

    private var arFragment: CustomArFragment? = null





    var placementIsDone = false;

    private var session: Session?=null
    private var shouldConfigureSession = false
    private val GLTF_ASSET = "https://github.com/KhronosGroup/glTF-Sample-Models/raw/master/2.0/Duck/glTF/Duck.gltf"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a_r)

        //arFragment=supportFragmentManager.findFragmentById(R.id.fragment) as CustomArFragment?
        //arFragment!!.getArSceneView()!!.getScene().addOnUpdateListener(this);



        val obj: Intent = intent
        val n1 = obj.getIntExtra("n1", 1)
        val n2 = obj.getIntExtra("n2", 1)
        val signo = obj.getIntExtra("signo", 1)

        numeros(n1, n2, signo)

        setupSession()
        ar_view.scene.addOnUpdateListener(this)



        //maybeEnableArButton();





    }

    fun numeros(n1: Int, n2: Int, signo: Int){
        val numeros= arrayListOf(
            R.drawable.numero_0,
            R.drawable.numero_1,
            R.drawable.numero_2,
            R.drawable.numero_3,
            R.drawable.numero_4,
            R.drawable.numero_5,
            R.drawable.numero_6,
            R.drawable.numero_7,
            R.drawable.numero_8,
            R.drawable.numero_9,
            R.drawable.numero_10
        );
        val signos=arrayListOf(
            R.drawable.signo_suma,
            R.drawable.signo_suma,
            R.drawable.signo_resta,
            R.drawable.signo_por
        )
        val viewn1 = findViewById<ImageView>(R.id.arn1)
        val viewsigno = findViewById<ImageView>(R.id.signo)
        val viewn2 = findViewById<ImageView>(R.id.arn2)

        viewn1.setImageResource(numeros[n1])
        viewn2.setImageResource(numeros[n2])
        viewsigno.setImageResource(signos[signo])

    }

    fun maybeEnableArButton(){
        val availability = ArCoreApk.getInstance().checkAvailability(this)
        if (availability.isTransient) {
            // Re-query at 5Hz while compatibility is checked in the background.
            Handler().postDelayed(Runnable { maybeEnableArButton() }, 200)





        }

    }

    fun createSession() {
        session = Session(applicationContext);
        val config = Config(session)
        // Set the Instant Placement mode.
        config.instantPlacementMode = Config.InstantPlacementMode.LOCAL_Y_UP
        session!!.configure(config)

        val imageDatabase = AugmentedImageDatabase(session);

        val bitmap = assets.open("target_1.png").use { BitmapFactory.decodeStream(it) }
        val imageWidthInMeters=1.0f
        val index = imageDatabase.addImage("one", bitmap, imageWidthInMeters)


        config.augmentedImageDatabase = imageDatabase
        session!!.configure(config)


    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
        if(session!=null) {
            session!!.pause()
            ar_view.pause()
        }
    }

    private fun  setupSession(){
        if(session == null)
        {
            try {
                session=Session(this)
            }catch (e: UnavailableArcoreNotInstalledException)
            {
               // e.printStackTrace()
            }
            catch (e: UnavailableApkTooOldException)
            {
                //e.printStackTrace()
            }
            catch (e: UnavailableSdkTooOldException)
            {
                //e.printStackTrace()
            }
            catch (e: UnavailableDeviceNotCompatibleException)
            {
                //e.printStackTrace()
            }

            shouldConfigureSession=true
        }
        if(shouldConfigureSession)
        {
            configSession()
            shouldConfigureSession=false
            ar_view.setupSession(session)
        }
        try {
            session!!.resume()
            ar_view.resume()
        }catch (e: CameraNotAvailableException)
        {
            e.printStackTrace()
            session = null
            return
        }
    }

    private fun configSession() {
        val config = Config(session)
        if(!buildDatabase(config))
            Toast.makeText(this@AR, "Error built-in database", Toast.LENGTH_SHORT).show()
        config.updateMode = Config.UpdateMode.LATEST_CAMERA_IMAGE
        session!!.configure(config)

    }

    private fun buildDatabase(config: Config): Boolean{
        val augmentedImageDatabase:AugmentedImageDatabase

        try{
            val inputStream=assets.open("edmtdev.imgdb")
            augmentedImageDatabase=AugmentedImageDatabase.deserialize(session!!,inputStream)
            config.augmentedImageDatabase = augmentedImageDatabase
            return true
        }
        catch (e: IOException){
            e.printStackTrace()
            return false
        }
        /*val bitmap = loadBitmapFromAsset()
        if(bitmap == null)
            return false

        augmentedImageDatabase = AugmentedImageDatabase(session)
        augmentedImageDatabase.addImage("target_1", bitmap)*/

        /*config.augmentedImageDatabase = augmentedImageDatabase
        return true*/
    }

    private fun loadBitmapFromAsset(): Bitmap? {
        val inputStream = assets.open("earth.jpg")
        return BitmapFactory.decodeStream(inputStream)
    }

    override fun onUpdate(p0: FrameTime?) {
        val frame = ar_view.arFrame
        val updateAugmentedImage = frame?.getUpdatedTrackables<AugmentedImage>(AugmentedImage::class.java)
        for (augmentedImg in updateAugmentedImage!!)
        {
            if(augmentedImg.trackingState == TrackingState.TRACKING)
            {
                if (augmentedImg.name.equals("target_1.jpg"))
                {
                    val node = Mynode(this,R.raw.articfox)
                    node.image = augmentedImg
                    ar_view.scene.addChild(node)
                }
                else if (augmentedImg.name.equals("target_2.jpg"))
                {
                    val node = Mynode(this,R.raw.bear)
                    node.image = augmentedImg
                    ar_view.scene.addChild(node)
                }
                else if (augmentedImg.name.equals("target_3.jpg"))
                {
                    val node = Mynode(this,R.raw.cat)
                    node.image = augmentedImg
                    ar_view.scene.addChild(node)
                }
                else if (augmentedImg.name.equals("target_4.jpg"))
                {
                    val node = Mynode(this,R.raw.elephant)
                    node.image = augmentedImg
                    ar_view.scene.addChild(node)
                }
                else if (augmentedImg.name.equals("target_5.jpg"))
                {
                    val node = Mynode(this,R.raw.ferret)
                    node.image = augmentedImg
                    ar_view.scene.addChild(node)
                }
                else if (augmentedImg.name.equals("target_6.jpg"))
                {
                    val node = Mynode(this,R.raw.lion)
                    node.image = augmentedImg
                    ar_view.scene.addChild(node)
                }
                else if (augmentedImg.name.equals("target_7.jpg"))
                {
                    val node = Mynode(this,R.raw.reindeer)
                    node.image = augmentedImg
                    ar_view.scene.addChild(node)
                }
                else if (augmentedImg.name.equals("target_8.jpg"))
                {
                    val node = Mynode(this,R.raw.meltann)
                    node.image = augmentedImg
                    ar_view.scene.addChild(node)
                }
                else if (augmentedImg.name.equals("target_9.jpg"))
                {
                    val node = Mynode(this,R.raw.articfox)
                    node.image = augmentedImg
                    ar_view.scene.addChild(node)
                }
                else if (augmentedImg.name.equals("target_10.jpg"))
                {
                    val node = Mynode(this,R.raw.articfox)
                    node.image = augmentedImg
                    ar_view.scene.addChild(node)
                }

            }
        }
    }


    /*fun setupDatabase(config: Config, session: Session){
        val foxBitmap = BitmapFactory.decodeResource(resources, R.drawable.earth)
        val aid = AugmentedImageDatabase(session)
        aid.addImage("target1", foxBitmap)
        config.setAugmentedImageDatabase(aid)

    }

    override fun onUpdate(p0: FrameTime?) {
        val frame = arFragment!!.arSceneView.arFrame
        val images = frame!!.getUpdatedTrackables(AugmentedImage::class.java)

        for (image in images){
            if(image.trackingState == TrackingState.TRACKING)
            {
                if(image.name.equals("target1"))
                {
                    val anchor: Anchor = image.createAnchor(image.centerPose)
                    createModel(anchor)
                }
            }
        }
    }

    fun createModel(anchor:Anchor){
        ModelRenderable.builder().setSource(this, Uri.parse("articfox.sfb"))
            .build()
            .thenAccept { modelRenderable -> placeModel(modelRenderable,anchor)  }
    }

    fun placeModel(modelRenderable: ModelRenderable,anchor:Anchor){
        var anchorNode:AnchorNode= AnchorNode(anchor)
        anchorNode.setRenderable(modelRenderable);
        arFragment!!.getArSceneView().getScene().addChild(anchorNode);
    }

*/

}