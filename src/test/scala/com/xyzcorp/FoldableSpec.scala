/*
 * Copyright 2018 Daniel Hinojosa
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN
 * AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR
 * IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE.
 */

package com.xyzcorp

import cats._
import cats.implicits._
import org.scalatest.{FunSpec, Matchers}

class FoldableSpec extends FunSpec with Matchers {

  describe("Foldable") {
    it(
      """folds elements like fold in the standard library,
        | but uses a type class for it""".stripMargin) {
      val result = Foldable.apply[List].fold(List("a", "b", "c"))
      result should be("abc")
    }
  }

  describe("FoldMap") {
    it("""will apply a map to all the elements
        |  before folding them""".stripMargin) {
      val result = Foldable[List]
        .foldMap(List("a", "b", "c"))(s => (s.charAt(0) + 1).toChar.toString)
      result should be("bcd")
    }
  }
}
