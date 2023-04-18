package lab4.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab4.*;

class GrupoTest {

    Grupo grupoIlimitado;
    Grupo grupoLimitado;
    Grupo grupoLimitado2;
    
    Aluno[] alunos;
    
    @BeforeEach
    void criaGrupo() {
        this.grupoIlimitado = new Grupo("LP2");
        this.grupoLimitado = new Grupo("Listas", 4);
        this.grupoLimitado2 = new Grupo("mapas", 1);
    }
    
    @BeforeEach
    void criaAlunos() {
        this.alunos = new Aluno[4];
        this.alunos[0] = new Aluno("Gabriel Reyes", "250", "Computação");
        this.alunos[1] = new Aluno("Lili Camposh", "200", "Computação");
        this.alunos[2] = new Aluno("Angela Ziegler", "202", "Medicina");
        this.alunos[3] = new Aluno("Torbjorn Lindholm", "201", "Engenharia Mecânica");
    }
    
    @Test
    void testHashCode() {
        assertNotEquals(grupoIlimitado.hashCode(), grupoLimitado.hashCode());
    }

    @Test
    void testGetNomeGrupo() {
        assertFalse(grupoLimitado.getNomeGrupo().equals(grupoLimitado2.getNomeGrupo()));
    }

    @Test
    void testGetParticipantes() {
        assertFalse(grupoLimitado.getNomeGrupo().equals(grupoLimitado2.getNomeGrupo()));
    }

    @Test
    void testGetQuantidadeDeParticipantes() {
        grupoLimitado.adicionaParticipantes(alunos[0]);
        grupoLimitado.adicionaParticipantes(alunos[1]);
        assertNotEquals(grupoLimitado, grupoLimitado2);
    }

    @Test
    void testGetLimiteDeParticipantes() {
        Grupo grupo = new Grupo("Programação", 4);
        assertEquals(grupoLimitado.getLimiteDeParticipantes(), grupo.getLimiteDeParticipantes());
    }

    @Test
    void testEqualsObject() {
        Grupo grupo = new Grupo("Programação");
        assertNotEquals(grupoIlimitado.getNomeGrupo(), grupo.getNomeGrupo());
    }
    
    @Test
    void testHashCode2() {
        Grupo grupo = new Grupo("LP2");
        assertEquals(grupoIlimitado.hashCode(), grupo.hashCode());
    }

    @Test
    void testAdicionaParticipantes() {
        try {
            for(Aluno ele: this.alunos) {
                grupoLimitado.adicionaParticipantes(ele);
            }
        } catch(IndexOutOfBoundsException error) {
            System.out.println("GRUPO CHEIO!\n");
        }
    }

    @Test
    void testGetNomeGrupo2() {
        assertTrue(grupoLimitado.getNomeGrupo().equals(grupoLimitado.getNomeGrupo()));
    }

    @Test
    void testGetParticipantes2() {
        assertTrue(grupoIlimitado.getNomeGrupo().equals(grupoIlimitado.getNomeGrupo()));
    }

    @Test
    void testGetQuantidadeDeParticipantes2() {
        grupoLimitado.adicionaParticipantes(alunos[0]);
        grupoLimitado2.adicionaParticipantes(alunos[2]);
        assertEquals(grupoLimitado.getQuantidadeDeParticipantes(), grupoLimitado2.getQuantidadeDeParticipantes());
    }

    @Test
    void testGetLimiteDeParticipantes2() {
        assertNotEquals(grupoLimitado.getLimiteDeParticipantes(), grupoLimitado2.getLimiteDeParticipantes());
    }

    @Test
    void testEqualsObject2() {
        Grupo grupo = new Grupo("listas");
        assertEquals(grupoLimitado.getNomeGrupo().toLowerCase(), grupo.getNomeGrupo().toLowerCase()); 
    }
}
