package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pack.MyFile;
import pack.Tabela;

class TabelaTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	MyFile myFile=new MyFile("Long-Method.xlsx");
	
	Tabela t=new Tabela(myFile);
	@Test
	final void testTabela() {
		assertTrue(myFile.getFileName().equalsIgnoreCase("Long-Method.xlsx"));
		
		
	}

	@Test
	final void testMain() {
		t.getValues();
		t.main(null);
		assertTrue(t.getFrame().isEnabled());
		t.initialize();
	}

}
