package SEF_App;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.List;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ArtistTest {


	    @Test
	    @Order(1)
	    public void testAddArtistValid() {
	    	Artist artist1 = new Artist("698SEFMA*&", "16-10-1999", "Brsibane|Queensland|Australia",
	              "A motivated director who is success driven in creating the best music videos and also a songwriter who focus in creating the best pop tracks",
	              List.of("Director", "Songwriter"),
	              List.of("2021, Best Director For the Year"),
	              List.of("pop", "jazz"));
	      assertTrue(artist1.isValidArtist());
	       
	        Artist artist2 = new Artist("987HHHUU!@", "04-08-2004", "Sydney|New South Wales|Australia",
	               "A talented producer, singer who loves playing the violin and produces fast-track music",
	                List.of("Singer", "Producer" ),
	                List.of("2017, Best violinist for the Year"),
	                List.of("pop", "jazz"));
	       assertTrue(artist2.isValidArtist());

	    }
	    
	    @Test
	    @Order(2)
	    public void testAddArtistInvalidID() {
	        // Test Data : 1 - Providing Invalid Artist ID without last 2 special characters
	        Artist artist3 = new Artist("567YXZHJK", "16-10-1999", "Brsibane|Queensland|Australia",
	                "A motivated director who is success driven in creating the best music videos and also a songwriter who focus in creating the best pop tracks",
	                List.of("Director", "Songwriter"),
                List.of("2021, Best Director For the Year."),
	                List.of("pop", "jazz"));
	        assertFalse(artist3.isValidArtist());
		        
		    // Test Data : 2 - Providing Artist ID more than 10 characters long
	        Artist artist4 = new Artist("567YXZHJKTYU*%", "16-10-1999", "Brsibane|Queensland|Australia",
	                "A motivated director who is success driven in creating the best music videos and also a songwriter who focus in creating the best pop tracks",
	                List.of("Director", "Songwriter"),
	                List.of("2021, Best Director For the Year"),
	                List.of("pop", "jazz"));
	        assertFalse(artist4.isValidArtist());
	        }


//invalid address
@Test
@Order(3)
  public void testAddAArtistInvalidAddress() {
      Artist artist5 = new Artist("698SEFMA*&", "16-10-1999", "Brisbane CBD|Brisbane|Queensland|Australia",
      		"A motivated director who is success driven in creating the best music videos and also a songwriter who focus in creating the best pop tracks",
              List.of("Director", "Songwriter"),
              List.of("2021, Best Director For the Year"),
              List.of("pop", "jazz"));
      assertFalse(artist5.isValidArtist());


      Artist artist6 = new Artist("698SEFMA*&", "16-10-1999", "Brisbane-Queensland-Australia",
      		"A motivated director who is success driven in creating the best music videos and also a songwriter who focus in creating the best pop tracks",
              List.of("Director", "Songwriter"),
              List.of("2021, Best Director For the Year"),
              List.of("pop","jazz"));
      
      assertFalse(artist6.isValidArtist());
}
      
  	
  // Invalid Bio
  @Test
  @Order(4)
  public void testAddArtistInvalidBio() {
    
	    Artist artist7 = new Artist("698SEFMA*&", "16-10-1999", "Brisbane-Queensland-Australia",
              "A motivated director ",
              List.of("Director", "Songwriter"),
              List.of("2021, Best Director For the Year"),
              List.of("pop", "jazz"));
	    assertFalse(artist7.isValidArtist());
	    
	
	    Artist artist8 = new Artist("698SEFMA*&", "16-10-1999", "Brisbane|Queensland|Australia",
              " A motivated director who is success driven in creating the best music videos and also a songwriter who focus in creating the best pop tracks. I also am well-versed with singing and created many playlists and albums in the genre of jazz and received many likings from the jazz world.",
              List.of("Director", "Songwriter"),
              List.of("2021, Best Director For the Year"),
              List.of("pop", "jazz"));
	    assertFalse(artist8.isValidArtist());
      }
  	
  //Invalid Occupations
  @Test
  @Order(5)
  public void testAddArtistInvalidOccupations() {
    
	    Artist artist9 = new Artist("698SEFMA*&", "16-10-1999", "Brisbane|Queensland|Australia",
              "A motivated director who is success driven in creating the best music videos and also a songwriter who focus in creating the best pop tracks",
              List.of("Singer", "Songwriter", "Producer", "Composer", "Dancer", "Director"),
              List.of("2021, Best Director For the Year"),
              List.of("pop", "jazz"));
	    assertFalse(artist9.isValidArtist());
	    
	  
	    Artist artist10 = new Artist("698SEFMA*&", "16-10-1999", "Brisbane|Queensland|Australia",
	    		"A motivated director who is success driven in creating the best music videos and also a songwriter who focus in creating the best pop tracks",
              List.of(),
              List.of("2021, Best Director For the Year"),
              List.of("pop", "jazz"));
	    assertFalse(artist10.isValidArtist());
  	    
          }
  	
	
 // Invalid Genres
  @Test
  @Order(6)
  public void testAddArtistInvalidGenres() {
     
	    Artist artist11 = new Artist("698SEFMA*&", "16-10-1999", "Brisbane|Queensland|Australia",
	    		"A motivated director who is success driven in creating the best music videos and also a songwriter who focus in creating the best pop tracks",
              List.of("Director", "Songwriter"),
              List.of("2021, Best Director For the Year"),
              List.of("pop", "rock"));
	    assertFalse(artist11.isValidArtist());
	    
	 
	    Artist artist12 = new Artist("698SEFMA*&", "16-10-1999", "Brisbane|Queensland|Australia",
              "A motivated director who is success driven in creating the best music videos and also a songwriter who focus in creating the best pop tracks",
              List.of("Director", "Songwriter"),
              List.of("2021, Best Director For the Year"),
              List.of("pop, jazz, western, cpop, classical, Bollywood, rap "));
	    assertFalse(artist12.isValidArtist());
  	    
  }

  
  
//UPDATE TESTS
  
  @Test
  @Order(7)
  public void testUpdateValid() {
      Artist artist13 = new Artist("698SEFMA*&", "16-10-1999", "Brisbane|Queensland|Australia",
      		"A motivated director who is success driven in creating the best music videos and also a songwriter who focus in creating the best pop tracks.",
              List.of("Director", "Songwriter"),
              List.of("2021, Best Director For the Year"),
              List.of("pop", "jazz"));

      assertTrue(artist13.updateArtist("698SEFMA*&", "17-10-2003", "Brisbane|Queensland|Australia",
      		"A motivated director who is success driven in creating the best music videos and also a songwriter who focus in creating the best pop tracks.",
              List.of("Director", "Songwriter", "Singer", "Dancer"),
              List.of("2021, Best Director For the Year"),
              List.of("pop", "jazz")));
      
      
      Artist artist14 = new Artist("987HHHUU!@", "17-10-2003", "Brisbane|Queensland|Australia",
      		"A motivated director who is success driven in creating the best music videos and also a songwriter who focus in creating the best pop tracks.",
              List.of("Singer", "Songwriter"),
              List.of("2022, Best Director For the Year"),
              List.of("pop", "jazz"));
  
      assertTrue(artist14.updateArtist("987HHHUU!@", "17-10-2003", "Brisbane|Queensland|Australia",
      		"A motivated director who is success driven in creating the best music videos and also a songwriter who focus in creating the best pop tracks.",
              List.of("Director", "Songwriter", "Singer", "Dancer"),
              List.of("2022, Best Songwriter For the Year"),
              List.of("pop", "jazz")));
  }
  

	    

	  @Test
	  @Order(8)
	  public void testUpdateInvalidBirthDate() {
	  	
	
	      Artist artist15 = new Artist("698SEFMA*&", "16-10-1999", "Brisbane|Queensland|Australia",
	      		"A motivated director who is success driven in creating the best music videos and also a songwriter who focus in creating the best pop tracks.",
	              List.of("Director", "Songwriter"),
	              List.of("2021, Best Director For the Year"),
	              List.of("pop", "jazz"));
	    
	      assertFalse(artist15.updateArtist("698SEFMA*&", "16/10/1999", "Brisbane|Queensland|Australia",
	              "A motivated director who is success driven in creating the best music videos and also a songwriter who focus in creating the best pop tracks.",
	              List.of("Director", "Songwriter"),
	              List.of("2021, Best Director For the Year"),
	              List.of("pop", "jazz")));
	      
	     
	      Artist artist16 = new Artist("698SEFMA*&", "16-10-1999", "Brisbane|Queensland|Australia",
	      		"A motivated director who is success driven in creating the best music videos and also a songwriter who focus in creating the best pop tracks.",
	              List.of("Director", "Songwriter"),
	              List.of("2021, Best Director For the Year"),
	              List.of("pop", "jazz"));
	   
	      assertFalse(artist16.updateArtist("698SEFMA*&", "1999-10-16", "Brisbane|Queensland|Australia",
	              "A motivated director who is success driven in creating the best music videos and also a songwriter who focus in creating the best pop tracks.",
	              List.of("Director", "Songwriter"),
	              List.of("2021, Best Director For the Year"),
	              List.of("pop", "jazz")));
	  }
	  
 
  @Test
  @Order(9)
  public void testUpdateInvalidAwards() {


      Artist artist17 = new Artist("698SEFMA*&", "16-10-1999", "Brisbane|Queensland|Australia",
        		"A motivated director who is success driven in creating the best music videos and also a songwriter who focus in creating the best pop tracks.",
                List.of("Director", "Songwriter"),
                List.of("1999, Best Director For the Year"),
                List.of("pop", "jazz"));
      assertFalse(artist17.updateArtist("698SEFMA*&", "16-10-1999", "Brisbane|Queensland|Australia",
      		"A motivated director who is success driven in creating the best music videos and also a songwriter who focus in creating the best pop tracks.",
              List.of("Director", "Songwriter"),
              List.of("1995, Best Album For the Year Award"),
              List.of("pop", "jazz")));
      
     
      Artist artist18 = new Artist("698SEFMA*&", "16-10-1999", "Brisbane|Queensland|Australia",
              "A motivated director who is success driven in creating the best music videos and also a songwriter who focus in creating the best pop tracks.",
              List.of("Director", "Songwriter"),
              List.of("2021, Best Director For the Year"),
              List.of("pop", "jazz"));
      assertFalse(artist18.updateArtist("698SEFMA*&", "16-10-1999", "Brisbane|Queensland|Australia",
              "A motivated director who is success driven in creating the best music videos and also a songwriter who focus in creating the best pop tracks.",
              List.of("Director", "Songwriter"),
              List.of("2012, song of the year", "2020, Best New Artist", "2019, music video of the Year","2018, International Solo Artist"),
              List.of("pop", "jazz")));
      
  }

  

  @Test
  @Order(10)
  public void testUpdateInvalidOccupation() {
  
      Artist artist19 = new Artist("698SEFMA*&", "16-10-1999", "Brisbane|Queensland|Australia",
              "A motivated director who is success driven in creating the best music videos and also a songwriter who focus in creating the best pop tracks.",
              List.of("Director", "Songwriter"),
              List.of("2021, Best Director For the Year"),
              List.of("pop", "jazz"));
      
    
      assertFalse(artist19.updateArtist("698SEFMA*&", "16-10-1999", "Brisbane|Queensland|Australia",
              "A motivated director who is success driven in creating the best music videos and also a songwriter who focus in creating the best pop tracks.",
              List.of("Composer, Dancer"),
              List.of("2021, Best Director For the Year"),
              List.of("pop", "jazz")));
      

      Artist artist20 = new Artist("698SEFMA*&", "08-12-2009", "Brisbane|Queensland|Australia",
              "A motivated director who is success driven in creating the best music videos and also a songwriter who focus in creating the best pop tracks.",
              List.of("Director", "Songwriter"),
              List.of("2021, Best Director For the Year"),
              List.of("pop", "jazz"));
      
     
      assertFalse(artist20.updateArtist("698SEFMA*&", "08-12-2009", "Brisbane|Queensland|Australia",
              "A motivated director who is success driven in creating the best music videos and also a songwriter who focus in creating the best pop tracks.",
              List.of("Director","Singer","Composer","violinist","guitarist","Dancer"),
              List.of("2021, Best Director For the Year"),
              List.of("pop", "jazz")));
      
  }
  
  
  
  @Test
  @Order(11)
  public void testUpdateInvalidGenre() {
  	
      Artist artist21 = new Artist("698SEFMA*&", "16-10-1999", "Brisbane|Queensland|Australia",
              "A motivated director who is success driven in creating the best music videos and also a songwriter who focus in creating the best pop tracks.",
              List.of("Director", "Songwriter"),
              List.of("2021, Best Director For the Year"),
              List.of("pop", "jazz"));
     
     
      assertFalse(artist21.updateArtist("698SEFMA*&", "16-10-1999", "Brisbane|Queensland|Australia",
              "A motivated director who is success driven in creating the best music videos and also a songwriter who focus in creating the best pop tracks.",
              List.of("Director", "Songwriter"),
              List.of("2021, Best Director For the Year"),
              List.of("pop", "rock")));
      
  
      Artist artist22 = new Artist("698SEFMA*&", "16-10-1999", "Brisbane|Queensland|Australia",
              "A motivated director who is success driven in creating the best music videos and also a songwriter who focus in creating the best pop tracks.",
              List.of("Director", "Songwriter"),
              List.of("2021, Best Director For the Year"),
              List.of("pop", "jazz"));
      
  
      assertFalse(artist22.updateArtist("698SEFMA*&", "16-10-1999", "Brisbane|Queensland|Australia",
              "A motivated director who is success driven in creating the best music videos and also a songwriter who focus in creating the best pop tracks.",
              List.of("Director", "Songwriter"),
              List.of("2021, Best Director For the Year"),
              List.of("jazz")));
      
  }
 
  
  @Test
  @Order(12)
  public void testUpdateInvalidID() {
  	
     
      Artist artist23 = new Artist("698SEFMA*&", "16-10-1999", "Brisbane|Queensland|Australia",
      		"A motivated director who is success driven in creating the best music videos and also a songwriter who focus in creating the best pop tracks.",
              List.of("Director", "Songwriter"),
              List.of("2021, Best Director For the Year"),
              List.of("pop", "jazz"));
    
      assertFalse(artist23.updateArtist("869HHYYIIG", "16-10-1999", "Brisbane|Queensland|Australia",
    	     "A motivated director who is success driven in creating the best music videos and also a songwriter who focus in creating the best pop tracks.",
              List.of("Director", "Songwriter"),
              List.of("2021, Best Director For the Year"),
              List.of("pop", "jazz")));
      
    
      Artist artist24 = new Artist("698SEFMA*&", "16-10-1999", "Brisbane|Queensland|Australia",
      		"A motivated director who is success driven in creating the best music videos and also a songwriter who focus in creating the best pop tracks.",
              List.of("Director", "Songwriter"),
              List.of("2021, Best Director For the Year"),
              List.of("pop", "jazz"));
     
      assertFalse(artist24.updateArtist("869HHYYIIGGKK", "16-10-1999", "Brisbane|Queensland|Australia",
      		"A motivated director who is success driven in creating the best music videos and also a songwriter who focus in creating the best pop tracks.",
              List.of("Director", "Songwriter"),
              List.of("2021, Best Director For the Year"),
              List.of("pop", "jazz")));
      
  }
  }

