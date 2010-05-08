package com.goldenweek.cards.model;


import static javax.jdo.annotations.IdGeneratorStrategy.*;
import static javax.jdo.annotations.IdentityType.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.goldenweek.cards.DatabaseContext;
import com.goldenweek.cards.exception.NoKeyException;
import com.google.appengine.api.datastore.Key;


@PersistenceCapable(identityType = APPLICATION, detachable = "true")
public class Context {

     /** プライマリキー */
     @PrimaryKey
     @Persistent(valueStrategy = IDENTITY)
     private Key key;

     @Persistent
     private Deck pool;

     //@Persistent
     private Deck discards;

     //@Persistent
     private List<Hand> hands;

     public Context(final int ... joker){
          initialize();
     }
     
     public void initialize(){
    	 initialize(0);
     }

     public void initialize(final int joker){

    	 List<Card> cardList = new ArrayList<Card>();
    	 
		 for(int i = 1; i<13; i++){
			 cardList.add(Card.createCard(Suit.SPADE, i));
		 }
		 for(int i = 1; i<13; i++){
			 cardList.add(Card.createCard(Suit.HEART, i));
		 }
		 for(int i = 1; i<13; i++){
			 cardList.add(Card.createCard(Suit.DIAMOND, i));
		 }
		 for(int i = 1; i<13; i++){
			 cardList.add(Card.createCard(Suit.CLUBS, i));
		 }
		 
		 for(int i = 0; i < joker; i++) {
			 cardList.add(Card.createJoker());
		 }

         this.pool = new Deck(cardList);

     }

     public Deck getPool(){
          return pool;
     }

     public Deck getDiscards(){
          return discards;
     }

     public List<Hand> getHands(){
          return hands;
     }

     public Hand getHand(final int num){
          return hands.get(num);
     }

    public long getId() {
    	if (key == null) {
    		throw new NoKeyException();
    	}
    	return key.getId();
    }

     public Card discardToPool(){
    	 return pool.add(discards.remove(discards.getAt(new Random(discards.size()).nextInt())));
     }

     public Card handToDiscard(final Hand hand, final Card card){
    	 return discards.add(hand.remove(hand.getAt(new Random(hand.size()).nextInt())));
     }

     public Card poolToHand(final Hand hand){
    	 int index = (int)(Math.random() * pool.size());
    	 return hand.add(pool.remove(pool.getAt(index)));
     }

     public Card[] discardToHand(final Hand hand, final Card ... card){
    	 for(int i=0; i<card.length; i++){
    		 hand.add(card[i]);
    		 discards.remove(card[i]);
    	 }
    	return card;
     }

     public Card handToHand(final Hand remHand, final Hand putHand, final Card card){
    	 remHand.remove(card);
    	 putHand.add(card);
    	 return card;
     }

    /**
     * IDをキーにレコードを検索します。
     *
     * @param id
     * 		ID
     * @return
     * 		{@link Context}
     * @throws JDOObjectNotFoundException
     * 		レコードが見つからなかった場合
     */
    public static Context findById(final long id) {
    	 return DatabaseContext.getPersistenceManager()
    	 		.getObjectById(Context.class, Long.valueOf(id));
     }

	/**
	 * 既にデータベースにレコードがあれば更新し、
	 * 無ければ新しくレコードを登録します。
	 *
	 * @return
	 * 		this
	 */
	public Context insertOrUpdate() {
		return DatabaseContext.getPersistenceManager().makePersistent(this);
	}

	/**
	 * データベースからレコードを削除します。
	 */
	public void delete() {
		DatabaseContext.getPersistenceManager().deletePersistent(this);
	}
}
