package dev.bensadiku.arandroidtest

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.math.Vector3
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.rendering.ViewRenderable
import com.google.ar.sceneform.ux.ArFragment
import com.google.ar.sceneform.ux.TransformableNode
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.name_animal.*

class MainActivity : AppCompatActivity() {
    var arrayView: Array<View>? = null
    var arFragment: ArFragment? = null
    var selected: Int = 1

    private lateinit var bearRendereable: ModelRenderable
    private lateinit var catRendereable: ModelRenderable
    private lateinit var dogRendereable: ModelRenderable
    private lateinit var cowRendereable: ModelRenderable
    private lateinit var elephantRendereable: ModelRenderable
    private lateinit var ferretRendereable: ModelRenderable
    private lateinit var hippopotamusRendereable: ModelRenderable
    private lateinit var horseRendereable: ModelRenderable
    private lateinit var koala_bearRendereable: ModelRenderable
    private lateinit var lionRendereable: ModelRenderable
    private lateinit var reindeerRendereable: ModelRenderable
    private lateinit var wolverineRendereable: ModelRenderable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        arFragment = supportFragmentManager.findFragmentById(R.id.sceneform_ux_fragment) as ArFragment

        setArrayView()
        setClickListener()
        setupModel()

        arFragment?.setOnTapArPlaneListener { hitResult, plane, motionEvent ->

            val anchor = hitResult.createAnchor()
            val anchorNode = AnchorNode(anchor)
            anchorNode.setParent(arFragment?.arSceneView?.scene)

            createModel(anchorNode, selected)

        }
    }

    override fun onPause() {
        super.onPause()
    }

    private fun setupModel() {
        ModelRenderable.builder()
            .setSource(this, R.raw.bear)
            .build()
            .thenAccept { renderable -> bearRendereable = renderable }
            .exceptionally {
                Toast.makeText(this, "Load failed ${it.message}", Toast.LENGTH_SHORT).show()
                null
            }

        ModelRenderable.builder()
            .setSource(this, R.raw.dog)
            .build()
            .thenAccept { renderable -> dogRendereable = renderable }
            .exceptionally {
                Toast.makeText(this, "Load failed ${it.message}", Toast.LENGTH_SHORT).show()
                null
            }

        ModelRenderable.builder()
            .setSource(this, R.raw.cat)
            .build()
            .thenAccept { renderable -> catRendereable = renderable }
            .exceptionally {
                Toast.makeText(this, "Load failed ${it.message}", Toast.LENGTH_SHORT).show()
                null
            }

        ModelRenderable.builder()
            .setSource(this, R.raw.cow)
            .build()
            .thenAccept { renderable -> cowRendereable = renderable }
            .exceptionally {
                Toast.makeText(this, "Load failed ${it.message}", Toast.LENGTH_SHORT).show()
                null
            }

        ModelRenderable.builder()
            .setSource(this, R.raw.elephant)
            .build()
            .thenAccept { renderable -> elephantRendereable = renderable }
            .exceptionally {
                Toast.makeText(this, "Load failed ${it.message}", Toast.LENGTH_SHORT).show()
                null
            }

        ModelRenderable.builder()
            .setSource(this, R.raw.ferret)
            .build()
            .thenAccept { renderable -> ferretRendereable = renderable }
            .exceptionally {
                Toast.makeText(this, "Load failed ${it.message}", Toast.LENGTH_SHORT).show()
                null
            }

        ModelRenderable.builder()
            .setSource(this, R.raw.hippopotamus)
            .build()
            .thenAccept { renderable -> hippopotamusRendereable = renderable }
            .exceptionally {
                Toast.makeText(this, "Load failed ${it.message}", Toast.LENGTH_SHORT).show()
                null
            }

        ModelRenderable.builder()
            .setSource(this, R.raw.horse)
            .build()
            .thenAccept { renderable -> horseRendereable = renderable }
            .exceptionally {
                Toast.makeText(this, "Load failed ${it.message}", Toast.LENGTH_SHORT).show()
                null
            }

        ModelRenderable.builder()
            .setSource(this, R.raw.koala_bear)
            .build()
            .thenAccept { renderable -> koala_bearRendereable = renderable }
            .exceptionally {
                Toast.makeText(this, "Load failed ${it.message}", Toast.LENGTH_SHORT).show()
                null
            }

        ModelRenderable.builder()
            .setSource(this, R.raw.lion)
            .build()
            .thenAccept { renderable -> lionRendereable = renderable }
            .exceptionally {
                Toast.makeText(this, "Load failed ${it.message}", Toast.LENGTH_SHORT).show()
                null
            }

        ModelRenderable.builder()
            .setSource(this, R.raw.reindeer)
            .build()
            .thenAccept { renderable -> reindeerRendereable = renderable }
            .exceptionally {
                Toast.makeText(this, "Load failed ${it.message}", Toast.LENGTH_SHORT).show()
                null
            }

        ModelRenderable.builder()
            .setSource(this, R.raw.wolverine)
            .build()
            .thenAccept { renderable -> wolverineRendereable = renderable }
            .exceptionally {
                Toast.makeText(this, "Load failed ${it.message}", Toast.LENGTH_SHORT).show()
                null
            }
    }

    private fun createModel(anchorNode: AnchorNode, selected: Int) {
        val renderableNode = TransformableNode(arFragment?.transformationSystem)
        renderableNode.setParent(anchorNode)
        when (selected) {
            1 -> {
                renderableNode.renderable = bearRendereable
                renderableNode.select()
                addName(anchorNode, renderableNode, "Bear")
            }
            2 ->{
                renderableNode.renderable = catRendereable
                renderableNode.select()
                addName(anchorNode, renderableNode, "Cat")
            }
            3 ->{
                renderableNode.renderable = dogRendereable
                renderableNode.select()
                addName(anchorNode, renderableNode, "Dog")
            }
            4 ->{
                renderableNode.renderable = cowRendereable
                renderableNode.select()
                addName(anchorNode, renderableNode, "Cow")
            }
            5 ->{
                renderableNode.renderable = elephantRendereable
                renderableNode.select()
                addName(anchorNode, renderableNode, "Elephant")
            }
            6 ->{
                renderableNode.renderable = ferretRendereable
                renderableNode.select()
                addName(anchorNode, renderableNode, "Ferret")
            }
            7 ->{
                renderableNode.renderable = ferretRendereable
                renderableNode.select()
                addName(anchorNode, renderableNode, "Hippopotamus")
            }
            8 ->{
                renderableNode.renderable = ferretRendereable
                renderableNode.select()
                addName(anchorNode, renderableNode, "Horse")
            }
            9 ->{
                renderableNode.renderable = ferretRendereable
                renderableNode.select()
                addName(anchorNode, renderableNode, "Koala Bear")
            }
            10 ->{
                renderableNode.renderable = ferretRendereable
                renderableNode.select()
                addName(anchorNode, renderableNode, "Lion")
            }
            11 ->{
                renderableNode.renderable = reindeerRendereable
                renderableNode.select()
                addName(anchorNode, renderableNode, "Reindeer")
            }
            12 ->{
                renderableNode.renderable = wolverineRendereable
                renderableNode.select()
                addName(anchorNode, renderableNode, "Wolverine")
            }
        }
    }

    private fun addName(anchorNode: AnchorNode, model: TransformableNode, name: String) {
        var animal_name: ViewRenderable? = null

        ViewRenderable.builder()
            .setView(this, R.layout.name_animal)
            .build()
            .thenAccept { renderable -> animal_name = renderable }

        val nameView = TransformableNode(arFragment?.transformationSystem)
        nameView.localPosition = Vector3(0f, model.localPosition.y + 0.5f, 0f)
        nameView.setParent(anchorNode)
        nameView.renderable = animal_name
        nameView.select()

        val nameAnimal = animal_name?.view as TextView
        nameAnimal.text = name

        nameAnimal.setOnClickListener {
            anchorNode.setParent(null)
        }
    }

    private fun setArrayView() {
        arrayView = arrayOf(
            bear
            , cat
            , dog
            , cow
            , elephant
            , ferret
            , hippopotamus
            , horse
            , koala_bear
            , lion
            , reindeer
            , wolverine
        )
    }

    private fun setClickListener() {
        for (view in arrayView!!) {
            view.setOnClickListener { thisView ->
                setBackground(thisView.id)
                when (thisView.id) {
                    R.id.bear -> selected = 1
                    R.id.cat -> selected = 2
                    R.id.dog -> selected = 3
                    R.id.cow -> selected = 4
                    R.id.elephant -> selected = 5
                    R.id.ferret -> selected = 6
                    R.id.hippopotamus -> selected = 7
                    R.id.horse -> selected = 8
                    R.id.koala_bear -> selected = 9
                    R.id.lion -> selected = 10
                    R.id.reindeer -> selected = 11
                    R.id.wolverine -> selected = 12
                }
            }
        }
    }

    private fun setBackground(id: Int) {
        for (view in arrayView!!) {
            if (view.id == id) {
                view.setBackgroundColor(Color.parseColor("#80333639"))
            } else {
                view.setBackgroundColor(Color.TRANSPARENT)
            }
        }
    }
}
