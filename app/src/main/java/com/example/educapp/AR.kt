package com.example.educapp

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.ar.core.*
import com.google.ar.core.exceptions.*
import com.google.ar.sceneform.FrameTime
import com.google.ar.sceneform.Scene
import kotlinx.android.synthetic.main.activity_a_r.*
import javax.microedition.khronos.opengles.GL10



class AR : AppCompatActivity(), Scene.OnUpdateListener {




    /*private lateinit var arFragment: ArFragment
    private lateinit var modelReadable: ModelRenderable
    private  var Model_URL: String = "https://github.com/EasylearnIndia/EasyLearn/blob/Augmented-Reality/EasyLearn/Assets/Models/tiger/tiger.glb?raw=true"
    */
    //private var session: Session? = null
    var placementIsDone = false;

    private var session: Session?=null
    private var shouldConfigureSession = false
    //var session = Session(applicationContext)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a_r)

        val obj: Intent = intent
        val n1 = obj.getIntExtra("n1", 1)
        val n2 = obj.getIntExtra("n2", 1)
        val signo = obj.getIntExtra("signo", 1)

        numeros(n1,n2,signo)

        setupSession()

        ar_view.scene.addOnUpdateListener(this)
        //maybeEnableArButton();
        //createSession()

        //onDrawFrame()


    }

    fun numeros(n1:Int,n2:Int,signo:Int){
        val numeros= arrayListOf(R.drawable.numero_0,R.drawable.numero_1,R.drawable.numero_2,R.drawable.numero_3,R.drawable.numero_4,R.drawable.numero_5,R.drawable.numero_6,R.drawable.numero_7,R.drawable.numero_8,R.drawable.numero_9,R.drawable.numero_10);
        val signos=arrayListOf(R.drawable.signo_suma,R.drawable.signo_suma,R.drawable.signo_resta,R.drawable.signo_por)
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
            }catch(e: UnavailableArcoreNotInstalledException)
            {
                e.printStackTrace()
            }
            catch (e: UnavailableApkTooOldException)
            {
                e.printStackTrace()
            }
            catch(e: UnavailableSdkTooOldException)
            {
                e.printStackTrace()
            }
            catch(e: UnavailableDeviceNotCompatibleException)
            {
                e.printStackTrace()
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
        if(!buildDatabase (config))
            Toast.makeText(this@AR, "Error built-in database", Toast.LENGTH_SHORT).show()
        config.updateMode = Config.UpdateMode.LATEST_CAMERA_IMAGE
        session!!.configure(config)

    }

    private fun buildDatabase(config: Config): Boolean{
        val augmentedImageDatabase:AugmentedImageDatabase
        val bitmap = loadBitmapFromAsset()
        if(bitmap == null)
            return false

        augmentedImageDatabase = AugmentedImageDatabase(session)
        augmentedImageDatabase.addImage("target_1",bitmap)
        config.augmentedImageDatabase = augmentedImageDatabase
        return true
    }

    private fun loadBitmapFromAsset(): Bitmap? {
        val inputStream = assets.open("target_1.png")
        return BitmapFactory.decodeStream(inputStream)
    }

    override fun onUpdate(p0: FrameTime?) {
        val frame = ar_view.arFrame
        val updateAugmentedImage = frame?.getUpdatedTrackables<AugmentedImage>(AugmentedImage::class.java)
        for (augmentedImg in updateAugmentedImage!!)
        {
            if(augmentedImg.trackingState == TrackingState.TRACKING)
            {
                if (augmentedImg.name.equals("target_1"))
                {
                    val node = Mynode(this,R.raw.meltanfbx)
                    node.image = augmentedImg
                    ar_view.scene.addChild(node)
                }
            }
        }
    }

    /*override fun onUpdate(p0: FrameTime?) {
        val frame = ar_view.arFrame
        val UpdateAugmentedImage = frame.getUpdatedTrackables<AugmentedImage>(AugmentedImage::class.java)

        for(AugmentedImage in UpdateAugmentedImage)
        {
            if(augmentedImage.trackingState== TrackingState.TRACKING)
            {
                if(augmentedImg.name.equals("target_1"))
                {
                    val node=MyNode(this,R.raw.meltan)
                    node.image=augmentedImg
                    ar_view.scene.addChild(node)
                }
            }
        }
    }*/

}