/*
 * Copyright 2019 Daniel Hinojosa
 *
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the "Software"),
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
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.xyzcorp.datatypes

import org.scalatest.{FunSpec, Matchers}

class ChainSpec extends FunSpec with Matchers {
    describe(
        """A Chain is a data structure of constant
          |  time prepending and appending. To be used where List and
          |  Vector incur a performance penalty. It supports both
          |  constant O(1) time append and prepend. It has four members of
          |  its ADT. Empty, Singleton, Append, Wrap""".stripMargin) {
        it("has an easy API using NonEmptyChain to create NonEmptyChains") {
            import cats.data._
            NonEmptyChain(1, 2, 3, 4)
        }
        it("can be created from a NonEmptyList") {
            import cats.data._
            NonEmptyChain.fromNonEmptyList(NonEmptyList(3, List(1, 2)))
        }
        it(
            """can be created using fromChainPrepend that
              |  prepends to an already created Chain""".stripMargin) {
            import cats.data._
            NonEmptyChain.fromChainPrepend(40, Chain.empty)
        }
        it(
            """can be created using fromChainAppend that
              |  appends to an already created Chain""".stripMargin) {
            import cats.data._
            NonEmptyChain.fromChainAppend(Chain.one(2), 4)
        }
        it("can be pattern matched?") {
            pending
            //Can an NEC be pattern matched?
        }

        //TODO:
        //Without checking, I'd guess that it's a newtyped wrapper
        // around NEL providing "zip" Applicative behavior instead
        // of the standard cartesian product behavior
    }
}
