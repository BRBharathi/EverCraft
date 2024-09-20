package com.accenture.boot.camp.evercraft;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class EvercraftApplicationTests {

     @Autowired
	private MockMvc mvc;
public CharacterSheet newCharacter=new CharacterSheet("Bharathi","Good");

	@Test
	void person_endpoint_if_name_is_provide() throws Exception {
		//given the user provide the name in the request parameter
		String name="Ram";
		//when the endpoint called
	MvcResult result= mvc.perform(get("/person?name="+name)).andReturn();
        //then the endpoints greets us with name
	     Assertions.assertEquals(200,result.getResponse().getStatus());
         Assertions.assertEquals("Hello"+name,result.getResponse().getContentAsString());
	}

	@Test
	void person_endpoint_will_default_name_to_person_if_a_name_is_not_provided_as_a_request_param() throws Exception
	{
		// given the user does not provide a name in the request parameters

		// when we call the endpoint
		MvcResult result = mvc.perform(get("/person")).andReturn();
		// then the endpoint greets us as "World"
		Assertions.assertEquals(200, result.getResponse().getStatus());
		Assertions.assertEquals("Hello, World", result.getResponse().getContentAsString());
	}

     @Test
	void new_character_possseses_attribute_with_name() throws Exception
	{

		//default name for the character
		String name="Bharathi";
		Assertions.assertEquals(name,newCharacter.getName());

	}
	@Test
	@DisplayName("default value for alignment")
	void new_character_posses_attribute_with_alignment() throws Exception{

		//default alignment fo the character
		String alignment="Good";
		Assertions.assertEquals(alignment,newCharacter.getAlignment());
	}

    @Test
	@DisplayName("Default value for armourClass")
	void character_combatant_posses_some_default_armour_class() throws Exception
	{
		//default armourclass value
		int armourClass=10;
		Assertions.assertEquals(armourClass,newCharacter.getArmourClass());
	}

	@Test
	@DisplayName(("Die roll number valid or invalid"))
	void die_roll_returns_a_valid_number()throws Exception{
         //given a new charactersheet
		//when i roll the die it should return valid between 1 and 20

		int validNumber=15;
		int inValidNumber=24;
		Assertions.assertEquals(validNumber,newCharacter.dieRoll(validNumber));
		Assertions.assertEquals(-1,newCharacter.dieRoll(inValidNumber));
	}
  /*  @Test
	void character_combat() throws Exception{

		//given a character
		//when i call the instance of the character
		//then instance should posses the correct default attributes
		int expectedArmourClass=10;
		int expectedHitPoints=5;
		Assertions.assertEquals(expectedArmourClass,newCharacter.getArmourClass());
		Assertions.assertEquals(expectedHitPoints,newCharacter.getHitPoints());
	}

	@Test
	void characterTest()throws Exception{

		String expectedName="Bharat";
		//CharacterSheet character=new CharacterSheet(expectedName);

		Assertions.assertEquals("Bharat",expectedName);


	}*/
}
