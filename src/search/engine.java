package search;

import java.util.ArrayList;

public class engine {
	/*
	private database myindex;
	private rankingAlgorithm myRanker;*/
	//Constructors are OK, but we must code database and ranking before
	/*
	public engine()
	{
		myindex = new containerDataStructure<TreeMap<String,TreeMap<Integer,wordAttributes>>,TreeMap<Integer,wordAttributes>>();
		myRanker = new aLitleBitSmarterAlgorithm();
	}
	public engine(database db)
	{
		myindex = db;
		myRanker = new notVerySmartRankingAlgorithm();
	}
	public engine(rankingAlgorithm rA)
	{
		myindex = new containerDataStructure<TreeMap<String,ArrayList<tangible.Pair<Integer,wordAttributes>>>,ArrayList<tangible.Pair<Integer,wordAttributes>>>();
		myRanker = rA;
	}
	public engine(database db, rankingAlgorithm rA)
	{
		myindex = db;
		myRanker = rA;
	}
	public engine(rankingAlgorithm rA, database db)
	{
		myindex = db;
		myRanker = rA;
	}*/
	//end of constructors 
	
	public final void indexFile(file fileToBeIndexed)
	{
			ArrayList<Pair<String,wordAttributes>> stat = this.analyze(fileToBeIndexed);
			String f = fileToBeIndexed.getFileName();
	}
	
	
	
	
	
	
	
	
	
	

}
