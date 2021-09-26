package com.github.ilze191

import java.io.{File, PrintWriter}
import scala.io.Source

object CookBookHomework extends App{
  val src = "src/resources/13177.txt"

  def getLinesFromFile(srcPath: String) = {
    val bufferedSource = Source.fromFile(srcPath)
    val lines = bufferedSource.getLines.toArray
    bufferedSource.close
    lines
  }

  val lines = getLinesFromFile(src)

//function of filtering recipe lines
  def titlesAndIngredients(lines: Array[String], starting: Int, ending: Int): Array[String] = {
    val recipeLines = lines.slice(starting, ending)
    val filteredLines = recipeLines.filter(line => line.toUpperCase == line && line.nonEmpty || line.trim.startsWith("_") || line.startsWith("  "))
    filteredLines
  }
  //  finding indexes of lines where recipes start and end
  val starting = lines.indexOf("FORMULA FOR MAKING THREE GALLONS OF BREAKFAST COCOA")
  val ending = lines.indexOf("WALTER BAKER & CO., Ltd.")

  val listWithRecipes = titlesAndIngredients(lines, starting, ending).mkString(sep = "\n\r")

  //making a new file
  val relative_save_path = "src/resources/List-with-recipes.txt"
  val pw = new PrintWriter(new File(relative_save_path ))
  pw.write(listWithRecipes)
  pw.close()
}
