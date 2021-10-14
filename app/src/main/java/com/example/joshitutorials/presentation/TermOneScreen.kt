package com.example.joshitutorials.presentation

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.joshitutorials.presentation.pdf_screen.PdfScreenViewModel
import com.github.barteksc.pdfviewer.PDFView
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle
import com.github.barteksc.pdfviewer.util.FitPolicy

@Composable
fun TermOneScreen(
    navController: NavHostController,
    chapterName: String?,
    mainActivity: MainActivity,
    pdfScreenViewModel: PdfScreenViewModel = hiltViewModel()
) {
//    val pdfView: PDFView = PDFView(mainActivity, null)
//    val file = mainActivity.getDir
            /*
            "Chapter 1: Sets",
        "Chapter 2: Relations and Functions",
        "Chapter 3: Trigonometric Functions",
//          "Chapter 4: Principle of Mathematical Induction",
        "Chapter 5: Complex Numbers and Quadratic Equations",
        "Chapter 6: Linear Inequalities",
        "Chapter 7: Permutations and Combinations",
        "Chapter 8: Binomial Theorem",
        "Chapter 9: Sequences and Series",
        "Chapter 10: Straight Lines",
        "Chapter 11: Conic Sections",
        "Chapter 12: Introduction to Three Dimensional Geometry",
        "Chapter 13: Limits and Derivatives",
        "Chapter 15: Statistics:",
        "Chapter 16: Probability"
            */
    chapterName?.let { pdfScreenViewModel.defineChapter(it) }
    val state2 = pdfScreenViewModel.chapterState.value

    when(state2){
        "Chapter 1: Sets"->{
            viewChapter(mainActivity = mainActivity,"sets.pdf")
        }
        "Chapter 2: Relations and Functions"->{
//            Toast.makeText(mainActivity, "Not implemented yet", Toast.LENGTH_LONG).show()
            viewChapter(mainActivity = mainActivity,"ch2rf.pdf")
        }

        "Chapter 4: Principle of Mathematical Induction"->{
//            Toast.makeText(mainActivity, "Not implemented yet", Toast.LENGTH_LONG).show()
            viewChapter(mainActivity = mainActivity,"ch4mi.pdf")
        }
        "Chapter 5: Complex Numbers and Quadratic Equations"->{
//            Toast.makeText(mainActivity, "Not implemented yet", Toast.LENGTH_LONG).show()
            viewChapter(mainActivity = mainActivity,"ch5cn.pdf")
        }
        "Chapter 6: Linear Inequalities"->{
//            Toast.makeText(mainActivity, "Not implemented yet", Toast.LENGTH_LONG).show()
            viewChapter(mainActivity = mainActivity,"ch6li.pdf")
        }
        "Chapter 7: Permutations and Combinations"->{
//            Toast.makeText(mainActivity, "Not implemented yet", Toast.LENGTH_LONG).show()
            viewChapter(mainActivity = mainActivity,"ch7pc.pdf")        }
        "Chapter 8: Binomial Theorem"->{
//            Toast.makeText(mainActivity, "Not implemented yet", Toast.LENGTH_LONG).show()
            viewChapter(mainActivity = mainActivity,"ch8b.pdf")        }

        "Chapter 9: Sequences and Series"->{
//            Toast.makeText(mainActivity, "Not implemented yet", Toast.LENGTH_LONG).show()
            viewChapter(mainActivity = mainActivity,"ch9ss.pdf")        }

        "Chapter 10: Straight Lines"->{
//            Toast.makeText(mainActivity, "Not implemented yet", Toast.LENGTH_LONG).show()
            viewChapter(mainActivity = mainActivity,"ch10s.pdf")        }

        "Chapter 11: Conic Sections"->{
//            Toast.makeText(mainActivity, "Not implemented yet", Toast.LENGTH_LONG).show()
            viewChapter(mainActivity = mainActivity,"ch11cs.pdf")        }

        "Chapter 12: Introduction to Three Dimensional Geometry"->{
//            Toast.makeText(mainActivity, "Not implemented yet", Toast.LENGTH_LONG).show()
            viewChapter(mainActivity = mainActivity,"ch12g.pdf")        }

        "Chapter 13: Limits and Derivatives"->{
//            Toast.makeText(mainActivity, "Not implemented yet", Toast.LENGTH_LONG).show()
            viewChapter(mainActivity = mainActivity,"ch13ld.pdf")        }

        "Chapter 15: Statistics"->{
//            Toast.makeText(mainActivity, "Not implemented yet", Toast.LENGTH_LONG).show()
            viewChapter(mainActivity = mainActivity,"ch15s.pdf")        }

        "Chapter 16: Probability"->{
//            Toast.makeText(mainActivity, "Not implemented yet", Toast.LENGTH_LONG).show()
            viewChapter(mainActivity = mainActivity,"ch16p.pdf")        }


        else -> {
            Toast.makeText(mainActivity,    "Unknown error occured", Toast.LENGTH_LONG).show()
        }
    }
}

@Composable
fun viewChapter(mainActivity: MainActivity, chapter: String) {
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = {context->
            PDFView(context, null)
        }
    ){pdfView->
        try {
            pdfView.fromAsset(chapter)
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .defaultPage(0)
                .enableAnnotationRendering(true) // render annotations (such as comments, colors or forms)
                .password(null)
                .scrollHandle(null)
                .enableAntialiasing(true) // improve rendering a little bit on low-res screens
                // spacing between pages in dp. To define spacing color, set view background
                .spacing(0)
                .autoSpacing(true) // add dynamic spacing to fit each page on its own on the screen
                .pageFitPolicy(FitPolicy.WIDTH) // mode to fit pages in the view
                .fitEachPage(false) // fit each page to the view, else smaller pages are scaled relative to largest page.
                .pageSnap(false) // snap pages to screen boundaries
                .pageFling(false) // make a fling change only a single page like ViewPager
                .nightMode(false) // toggle night mode
                .scrollHandle(DefaultScrollHandle(mainActivity))
                .load();
        }catch(e: Exception){
            Toast.makeText(mainActivity, e.toString(), Toast.LENGTH_LONG).show()
        }

    }
}