/**
 * Created by marvin on 15-8-16.
 */

import java.io.FileNotFoundException
import scala.io.Source
import java.io._
import scala.xml._

object RWTool{

  def readFromFile(fileName:String):List[String] = {
    try{
      val f = new File(fileName)
      val  fileContents = Source.fromFile(f).getLines.toList
      fileContents
    }catch{
      case e:FileNotFoundException => println("Find read file failed!")
        List("wrong")
    }
  }

  def writeToFile(fileName:String,content:List[String]){
    val f = new File(fileName)
    val p = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
      new FileOutputStream(f),"UTF-8")))
    val data = content
    try{
      data.foreach(p.println)
    }catch{
      case e:FileNotFoundException => println("Find write file failed!")
    }finally{
      p.close()
    }
  }

  //libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "1.*.*"
  def loadXML(filename:String):Elem = {
    try{
      val xmlFile = XML.loadFile(filename)
      xmlFile
    }catch{
      case e:FileNotFoundException => println("Find xml load file failed!")
        <wrong>wrong</wrong>
    }

  }




}
