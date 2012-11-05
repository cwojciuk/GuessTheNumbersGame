package guessthenumbersgame.caw;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;



/**
 * guessthenumbersgame.NumberService.java
 *
 * Nov 5, 2012
 *
 * @author Chuck Wojciuk
 */
public class NumberService {


    private int guessThisNumber;
    private int rangeMax;
    private Random randomizeRangeMax;
    private Random randomizeGuessThisNumber;
    public final void startNewGame() {
        this.guessThisNumber = 0;
        this.rangeMax = 0;

        randomize();
    }


    public final int getRangeMax() {
        return rangeMax;
    }


    public final List guess( int playerGuess ) {
        List guessList = new ArrayList();
        if ( playerGuess == guessThisNumber ) {
            guessList.add( true );
            guessList.add( "Perfect!" );
        } else if ( playerGuess > guessThisNumber ) {
            guessList.add( false );
            guessList.add( "Lower!" );
        } else {
            guessList.add( false );
            guessList.add( "Higer!" );
        }
        return guessList;
    }


    private void randomize() {
        randomizeRangeMax = new Random();
        randomizeGuessThisNumber = new Random();

        rangeMax = randomizeRangeMax.nextInt( 1000 );
        guessThisNumber = randomizeGuessThisNumber.nextInt( rangeMax );

    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.guessThisNumber;
        hash = 23 * hash + this.rangeMax;
        hash = 23 * hash + Objects.hashCode( this.randomizeRangeMax );
        hash = 23 * hash + Objects.hashCode( this.randomizeGuessThisNumber );
        return hash;
    }


    @Override
    public boolean equals( Object obj ) {
        if ( obj == null ) {
            return false;
        }
        if ( getClass() != obj.getClass() ) {
            return false;
        }
        final NumberService other = ( NumberService ) obj;
        if ( this.guessThisNumber != other.guessThisNumber ) {
            return false;
        }
        if ( this.rangeMax != other.rangeMax ) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "NumberService{" + "guessThisNumber=" + guessThisNumber +
               ", rangeMax=" + rangeMax + '}';
    }


}

