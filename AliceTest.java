/*
 * Copyright 2022 Andrew Rice <acr31@cam.ac.uk>, M. Haji
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.ac.cam.mh2169.alice;

import static com.google.common.truth.Truth.assertThat;
import static uk.ac.cam.mh2169.alice.Main.load;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AliceTest {

  @Test
  public void countWords_returns0_forEmptyList() {
    // ARRANGE
    List<Token> words = List.of();

    // ACT
    long count = Alice.countWords(words);

    // ASSEERT
    assertThat(count).isEqualTo(0);
  }

  @Test
  public void countWords_returns0_whenOnlyPunctuation() {
    // ARRANGE
    List<Token> words = List.of(new Token(".", ".", 1.0), new Token(",", ",", 1.0));

    // ACT
    long count = Alice.countWords(words);

    // ASSEERT
    assertThat(count).isEqualTo(0);
  }
//
  @Test
  public void countWordsReturnsTheRightNumberOfWords(){
    List<Token> tokensdup = List.of(
            new Token("Bob", "Pop", 1.0),
            new Token("Candice", "P", 0.23),
            new Token("lucky", "what", 1.0),
            new Token("Ash", "ketchup", 0.64),
            new Token("Ash", "ketchup", 0.64)
    );

    List<Token> tokens2 = List.of(
            new Token("John", "NNP", 1.0),
            new Token("john", "NP", 1.0),
            new Token("Elizabeth", "NNP", 1.0),
            new Token("eliza", "NP", 0.0),
            new Token("Spain", "NNP", 0.3),
            new Token("the", "NP", 0.9));

    List<Token> notWords = List.of(
            new Token("I.", "NNP", 0.5),
            new Token("Rabbit-Hole", "NNP", 0.8),
            new Token("?", ".", 1.0),
            new Token("(", "-LRB-", 0.9),
            new Token("," ,",", 0.9),
            new Token(")", "-RRB-", 0.9));


    assertThat(Alice.countWords(tokensdup)).isEqualTo(5);
    assertThat(Alice.countWords(tokens2)).isEqualTo(6);
    assertThat(Alice.countWords(notWords)).isEqualTo(0);

  }
  @Test
  public void leastConfidentReturnsExpectedValue(){
    List<Token> tokens = List.of(
            new Token("I.", "NNP", 0.5),
            new Token("Rabbit-Hole", "NNP", 0.8),
            new Token("?", ".", 1.0),
            new Token("(", "-LRB-", 0.9),
            new Token("," ,",", 0.9),
            new Token(")", "-RRB-", 0.9),
            new Token("John", "NNP", 1.0),
            new Token("john", "NP", 1.0),
            new Token("Elizabeth", "NNP", 1.0),
            new Token("eliza", "NP", 0.0),
            new Token("Spain", "NNP", 0.3),
            new Token("the", "NP", 0.9));
    assertThat(Alice.leastConfidentToken(tokens).toString()).isEqualTo("eliza(NP:0.0)");

  }




//  @Test
//  public void expectedMainResults() throws IOException{
//    // Tests the values expected when using the alice.txt file.
//    List<Token> tokens = load("alice.txt");
//    assertThat(Alice.posFrequencies(tokens).toString()).isEqualTo("{NN=3234, JJ=1424, ``=2, -LRB-=54, WRB=177, LS=1, PRP=2597, DT=2932, NNP=1843, FW=5, NNS=799, JJS=34, UH=61, JJR=64, MD=437, VBD=2541, WP=195, VBG=608, CC=1094, ''=209, CD=193, PDT=35, RBS=8, VBN=405, RBR=44, $=1, IN=3060, VBP=510, WDT=95, SYM=1, NNPS=5, WP$=2, VB=1186, ,=2421, .=1877, VBZ=263, RB=2275, PRP$=494, EX=65, POS=1, -RRB-=55, :=418, TO=720, RP=200}");
//    assertThat(Alice.leastConfidentToken(tokens).toString()).isEqualTo("patted(VBD:0.0)");
//    assertThat(Alice.properNouns(tokens, 10).toString().substring(0, 8)).isEqualTo("[Alice, ");
//    assertThat(Alice.properNouns(tokens, 10).toString().substring(11)).isEqualTo("Queen, King, Mock, Turtle, Gryphon, Hatter, *, Duchess]");
//    assertThat(Alice.countWords(tokens)).isEqualTo(24876);
//    assertThat(Alice.vocabulary(tokens, 5).toString()).isEqualTo("[the, and, to, a, she]");
//  }


//  @Test
//  public void expectedMainResultLeastConfidentToken() throws IOException {
//    List<Token> tokens = load("alice.txt");
//  }
//  @Test
//  public void expectedMainResult10MostFrequentProperNouns () throws IOException{
//    List<Token> tokens = load("alice.txt");
//    assertThat(Alice.properNouns(tokens, 10).toString()).isEqualTo("[Alice, �, Queen, King, Mock, Turtle, Gryphon, Hatter, *, Duchess]");
//  }
//  public void expectedMainResult5MostFrequentWords () throws IOException{
//    List<Token> tokens = load("alice.txt");
//  }
//  public void expectedMainResultTotalNumberOfWords () throws IOException{
//    List<Token> tokens = load("alice.txt");
//  }
  @Test
  public void PoSFrequenciesReturnsTheRightValues(){
    List<Token> tokens = List.of(
            new Token("I.", "NNP", 0.5),
            new Token("Rabbit-Hole", "NNP", 0.8),
            new Token("?", ".", 1.0),
            new Token("(", "-LRB-", 0.9),
            new Token("," ,",", 0.9),
            new Token(")", "-RRB-", 0.9),
            new Token("John", "NNP", 1.0),
            new Token("john", "NP", 1.0),
            new Token("Elizabeth", "NNP", 1.0),
            new Token("eliza", "NP", 0.0),
            new Token("Spain", "NNP", 0.3),
            new Token("the", "NP", 0.9));

    assertThat(Alice.posFrequencies(tokens).toString()).isEqualTo("{NNP=5, NP=3, -LRB-=1, -RRB-=1, ,=1, .=1}");
  }

  @Test
  public void vocabulary_ignoresCase() {
    // ARRANGE
    List<Token> words =
        List.of(
            new Token("Alice", "NNP", 1.0),
            new Token("alice", "NNP", 1.0),
            new Token("Queen", "NNP", 1.0),
            new Token("King", "NNP", 1.0),
            new Token("King", "NNP", 1.0));

    // ACT
    List<String> vocab = Alice.vocabulary(words, 2);

    // ASSERT
    assertThat(vocab).containsExactly("alice", "king");
  }

  @Test
  public void topN_returnsTopOne() {
    // ARRANGE
    Map<String, Long> frequencies = Map.of("apple", 10L, "pear", 5L, "banana", 1L);

    // ACT
    List<String> top = Alice.topN(1, frequencies);

    // ASSERT
    assertThat(top).containsExactly("apple");
  }


  @Test
  public void properNounsReturnsRightValues (){
    List<Token> tokens2 = List.of(
            new Token("John", "NNP", 1.0),
            new Token("john", "NP", 1.0),
            new Token("Elizabeth", "NNP", 1.0),
            new Token("eliza", "NP", 1.0),
            new Token("Spain", "NNP", 1.0),
            new Token("the", "NP", 1.0));

    assertThat(Alice.properNouns(tokens2, 3).toString()).isEqualTo("[Elizabeth, John, Spain]");
  }
  @Test
  public void topN_returnsAll_ifNotEnoughPresent() {
    // ARRANGE
    Map<String, Long> frequencies = Map.of("apple", 10L, "pear", 5L, "banana", 1L);

    // ACT
    List<String> top = Alice.topN(10, frequencies);

    // ASSERT
    assertThat(top).containsExactly("apple", "pear", "banana");
  }

  // This test is not really useful but its here to make sure we get coverage of the Token class
  @Test
  public void tokenToString_returnsOneDecimalPlace() {
    // ARRANGE
    Token token = new Token("Alice", "NNP", 1.888);

    // ACT
    String string = token.toString();

    // ASSERT
    assertThat(string).isEqualTo(String.format("Alice(NNP:%.1f)", 1.9));
  }
}
