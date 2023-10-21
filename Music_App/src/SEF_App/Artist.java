package SEF_App;
    import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
	import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
		
		public class Artist
		{

		private String ID;

		private String Address;
		private String Birthdate;
		private String Bio;
		private List <String> Occupations;
		private List<String> Awards;
		private List<String> Genres;
		
		
		public Artist(String id, String birthDate, String address, String bio, List<String> occupations,List<String> awards, List<String> genres) {
		    this.ID=id;

		    this.Address = address;
		    this.Birthdate = birthDate;
		    this.Bio = bio; 
		    this.Occupations = occupations;
		    this.Genres  = genres; 
		    this.Awards = awards;
		   
		    
		    if (isValidArtist()) 
		    { System.out.println(ID+"Artist Added successfully");
		    	writeToFile();
		    }
		    else {
		    	System.out.println(ID+"Invalid Artist\n");
		    }
		}


		
		
		boolean isValidArtist()
		{
//		    
		    if (!isValidArtistID(ID) || !isValidBirthDate(Birthdate) || !isValidAddress(Address)
			        || !isValidBio(Bio) || !isValidOccupations(Occupations) || !isValidAwards(Awards)
			        || !isValidGenres(Genres)) {
		    	
			        return false;
			    }
		    
			    return true;
		}

		   protected boolean isValidArtistID(String ID) {
			if (ID.length() != 10) {
				return false;
		    }
		
		    String x = ID.substring(0, 3);
		    if (!x.matches("[5-9]{3}")) {
		        return false;
		    }
		
		    String y = ID.substring(3, 8);
		    if (!y.matches("[A-Z]{5}")) {
		        return false;
		    }
		
		    String z = ID.substring(8);
		    if (!z.matches("[^A-Za-z0-9]{2}")) {
		        return false;
		    }

		    return true;
		}
		

		private boolean isValidBirthDate(String birthDate) {
		    // Condition 2: Birth Date

		    return birthDate.matches("^\\d{2}-\\d{2}-\\d{4}");
		}

		private boolean isValidAddress(String address) {
		    // Condition 3: Address

			    String[] parts = address.split("\\|");
			    
			    // Check if there are exactly three parts (City, State, Country)
			    if (parts.length != 3) {
			        return false;
			    }
			    
			    // Check if each part is not empty
			    for (String part : parts) {
			        if (part.isEmpty()) {
			            return false;
			        }
			    }
			   
//				System.out.println(ID+"address WORKED");
			    return true;
		}

		private boolean isValidBio(String bio) {
		    // Condition 4: Bio
		    int wordCount = bio.split("\\s+").length;

		    return wordCount >= 10 && wordCount <= 30;
		}

		private boolean isValidOccupations(List<String> occupations) {
		    // Condition 5: Occupations

		    return occupations.size() >= 1 && occupations.size() <= 5;
		}

		private boolean isValidAwards(List<String> awards) {
		    if (awards.size() > 3) {
		        return false;
		    }
		
		    for (String award : awards) {
		        String[] parts = award.split(",\\s*", 2); 
		        if (parts.length != 2) {
		            return false; 
		        }
		        
		        String title = parts[1].trim();
		        if (!title.matches("^\\w+(\\s+\\w+){3,9}$")) {
		            return false; 
		        }
		
		        if (!parts[0].matches("\\d{4}")) {
		            return false; 
		        }
		    }

		    return true;
		}


		private boolean isValidGenres(List<String> genres) {
		
				    return genres.size() >= 2 && genres.size() <= 5
				        && !(genres.contains("pop") && genres.contains("rock"));
				
		}
		
		//UPDATE FUNCTION
		public boolean updateArtist(String newArtistID, String newBirthDate, String newAddress, String newBio, 
		        List<String> newOccupations, List<String> newAwards, List<String> newMusicGenres) 
		{
		    if (!isValidArtistID(newArtistID) || !isValidBirthDate(newBirthDate) || !isValidAddress(newAddress)
		    || !isValidBio(newBio) || !isValidOccupations(newOccupations) || !isValidAwards(newAwards)
		    || !isValidGenres(newMusicGenres)) {
	 		System.out.println("Invalid artist information. Update failed");
		        return false;
		    }
		    
		    // If born before 2000, occupation cannot be changed
		    int birthYear = Integer.parseInt(newBirthDate.substring(6));
		    
		    if (birthYear < 2000) {
		        if (!newOccupations.equals(Occupations)) {
		            return false;
		        }
		    }
		      
		    // Awards given before 2000 cannot be changed
		    for (String award : Awards) {
		        String[] parts = award.split(",\\s*", 2);
		        int awardYear = Integer.parseInt(parts[0]);
		        
		        if (awardYear < 2000) {
	// Checking new awards
		            for (String newAward : newAwards) {
		                String[] newParts = newAward.split(",\\s*", 2);
		                int newAwardYear = Integer.parseInt(newParts[0]);
		     
		                if (newAwardYear != awardYear) {
		                    return false; // Award year cannot be changed
		                }
		            }
		        }
		    }
		    
		    // If all conditions are met, update the artist's information
		    this.ID = newArtistID;
		    this.Birthdate = newBirthDate;
		    this.Address = newAddress;
		    this.Bio = newBio;
		    this.Occupations = newOccupations;
		    this.Awards = newAwards;
		    this.Genres = newMusicGenres;
		    
		    System.out.println("Artist information updated successfully.");
		    
		 writeToFile();
	    return true;
		}
		
		
		//Adding to file
		private void writeToFile() {
		    try {
		        File file = new File("C:/Users/aynab/eclipse-workspace/Music_App/src/SEF_App/artist.txt");
		        BufferedReader reader = new BufferedReader(new FileReader(file));
		        List<String> lines = new ArrayList<>();
		        String line;

		        while ((line = reader.readLine()) != null) {
		            lines.add(line);
		        }
		        reader.close();

		        boolean artistExists = false;
		        for (int i = 0; i < lines.size(); i++) {
		            if (lines.get(i).startsWith("Artist ID: " + ID)) {
		                artistExists = true;
		                lines.set(i, "Artist ID: " + ID);
		                lines.set(i + 1, "Birth Date: " + Birthdate);
		                lines.set(i + 2, "Address: " + Address);
		                lines.set(i + 3, "Bio: " + Bio);
		                lines.set(i + 4, "Occupations: " + Occupations);
		                lines.set(i + 5, "Awards: " + Awards);
		                lines.set(i + 6, "Music Genres: " + Genres);
		                break;
		            }
		        }

		        if (!artistExists) {
		            lines.add("Artist ID: " + ID);
		            lines.add("Birth Date: " + Birthdate);
		            lines.add("Address: " + Address);
		            lines.add("Bio: " + Bio);
		            lines.add("Occupations: " + Occupations);
		            lines.add("Awards: " + Awards);
		            lines.add("Music Genres: " + Genres+"\n");
		            System.out.println("Artsit "+ID+" added successfully");
		        }

		        FileWriter writer = new FileWriter(file);
		        for (String updatedLine : lines) {
		            writer.write(updatedLine + "\n");
		        }
		        writer.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
	}
		
		

		




