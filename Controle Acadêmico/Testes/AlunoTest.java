package lab4.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab4.*;

class AlunoTest {
    
    Aluno aluno1;
    Aluno aluno2;
    Aluno aluno3;
    Aluno aluno4;

    @BeforeEach
    void criaAluno() {
        this.aluno1 = new Aluno("Gabriel Reyes", "250", "Computação");
        this.aluno2= new Aluno("Lili Camposh", "200", "Computação");
        this.aluno3 = new Aluno("Angela Ziegler", "202", "Medicina");
        this.aluno4 = new Aluno("Torbjorn Lindholm", "201", "Engenharia Mecânica");
    }
    
    @Test
    void testHashCode() {
        Aluno aluno =  new Aluno("Gabriel Reyes", "250", "Computação");
        assertEquals(aluno.hashCode(), aluno1.hashCode());
    }

    @Test
    void testGetNome() {
        assertEquals("Gabriel Reyes", this.aluno1.getNome());
    }

    @Test
    void testGetMatricula() {
        assertEquals("250", this.aluno1.getMatricula());
    }

    @Test
    void testGetCurso() {
        assertEquals("Computação", this.aluno1.getCurso());
    }

    @Test
    void testToString() {
        assertEquals("250 - Gabriel Reyes - Computação", this.aluno1.toString());
    }

    @Test
    void testEqualsObject() {
        Aluno aluno =  new Aluno("Gabriel Reyes", "250", "Computação");
        assertEquals(true, (aluno.getMatricula()).equals(aluno1.getMatricula()));
    }
    
    @Test
    void testHashCode2() {
        assertNotEquals(aluno1.hashCode(), aluno2.hashCode());
    }

    @Test
    void testGetNome2() {
        assertNotEquals("Gabriel Reyes", this.aluno2.getNome());
    }

    @Test
    void testGetMatricula2() {
        assertNotEquals("250", this.aluno2.getMatricula());
    }

    @Test
    void testGetCurso2() {
        assertEquals("Computação", this.aluno2.getCurso());
    }

    @Test
    void testToString2() {
        assertFalse((aluno2.toString()).equals(aluno1.toString()));
    }

    @Test
    void testEqualsObject2() {
        assertTrue((this.aluno2.getMatricula()).equals(aluno2.getMatricula()));
    }    

    @Test
    void testHashCode3() {
        assertEquals(aluno3.hashCode(), aluno3.hashCode());
    }

    @Test
    void testGetNome3() {
        assertEquals("Angela Ziegler", this.aluno3.getNome());
    }

    @Test
    void testGetMatricula3() {
        assertEquals("202", this.aluno3.getMatricula());
    }

    @Test
    void testGetCurso3() {
        assertNotEquals("Computação", this.aluno3.getCurso());
    }

    @Test
    void testToString3() {
        assertNotEquals("Torbjorn Lindholm - 201 - Engenharia Mecânica", this.aluno3.toString());
    }

    @Test
    void testEqualsObject3() {
        assertFalse((this.aluno4.getMatricula()).equals(aluno2.getMatricula()));
    }

    @Test
    void testHashCode4() {
        Aluno aluno =  new Aluno("Gabriel Reyes", "250", "Computação");
        assertNotEquals(aluno.hashCode(), aluno4.hashCode());
    }

    @Test
    void testGetNome4() {
        assertFalse((aluno4.getNome()).equals(aluno3.getNome()));
    }

    @Test
    void testGetMatricula4() {
        assertFalse((aluno4.getMatricula()).equals(aluno3.getMatricula()));
    }

    @Test
    void testGetCurso4() {
        assertFalse((aluno4.getCurso()).equals(aluno3.getCurso()));
    }

    @Test
    void testToString4() {
        assertFalse((aluno4.toString()).equals(aluno3.toString()));
    }

    @Test
    void testEqualsObject4() {
        assertFalse((aluno4.getMatricula()).equals(aluno3.getMatricula()));
    }
}
