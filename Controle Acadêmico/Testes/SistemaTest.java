package lab4.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab4.*;

class SistemaTest {
    
    Sistema sistema;

    @BeforeEach
    void preparaSistema() {
    	this.sistema = new Sistema();
    	this.sistema.cadastraAlunoSistema("Gabriel Reyes", "250", "Computação");
    	this.sistema.cadastraAlunoSistema("Lili Camposh", "200", "Computação");
    	this.sistema.cadastraAlunoSistema("Angela Ziegler", "202", "Medicina");
    	this.sistema.cadastraAlunoSistema("Torbjorn Lindholm", "201", "Engenharia Mecânica");
    	
    	sistema.cadastraGrupoNoSistema("LP2");
        sistema.cadastraGrupoLimitadoSistema("Java", 1);
    }
    
    @Test
    void testCadastraAlunoNuloNoSistema() {
        try {
            sistema.cadastraAlunoSistema(null, null, null);
        } catch (NullPointerException error) {}
    }

    @Test
    void testExibeAlunoCadastrado() {
        assertEquals("Aluno: 250 - Gabriel Reyes - Computação\n", sistema.exibeAlunoCadastrado("250"));
    }
    
    @Test
    void testTentaExibirAlunoNaoCadastrado() {
        assertEquals("ALUNO NÃO CADASTRADO.\n", sistema.exibeAlunoCadastrado("123"));
    }

    @Test
    void testCadastraGrupoNoSistema() {
    	assertEquals("CADASTRO REALIZADO!\n", sistema.cadastraGrupoNoSistema("Programação OO"));
    }
    
    @Test
    void testCadastraGrupoLimitadoNoSistema() {
        assertEquals("CADASTRO REALIZADO!\n", sistema.cadastraGrupoLimitadoSistema("Listas", 10));
    }
    
    @Test
    void testTentaCadastrarGrupoRepetidoNoSistema() {
        sistema.cadastraGrupoLimitadoSistema("Listas", 10);
        assertEquals("GRUPO JÁ CADASTRADO!\n", sistema.cadastraGrupoNoSistema("Listas"));
    }
    
    @Test
    void testChecaSeGrupoFoiCadastrado() {
        assertEquals("lp2", sistema.nomeDoGrupoToLowerCase("lp2"));
    }

    @Test
    void testCadastraGrupoLimitadoNuloNoSistema() {
        try {
            sistema.cadastraGrupoLimitadoSistema(null, 1);
        } catch (NullPointerException error) {}
    }
    
    @Test
    void testCadastraGrupoLimitadoTamanhoInvalidoNoSistema() {
    	assertEquals("GRUPO INVÁLIDO!\n", sistema.cadastraGrupoLimitadoSistema("Programação", 0));
    }

    @Test
    void testCadastraGrupoNoSistema2() {
        sistema.cadastraGrupoNoSistema("lp2");
		assertEquals("GRUPO JÁ CADASTRADO!\n", sistema.cadastraGrupoNoSistema("lp2"));
    }

    @Test
    void testTentaAlocarEmGrupoCheio() {
        try {
            sistema.cadastraGrupoNoSistema("Programação OO");
            sistema.alocaAlunoEmGrupoSistema("250", "Programação OO");
            sistema.alocaAlunoEmGrupoSistema("201", "Programação OO");
            assertEquals("GRUPO CHEIO!\n", sistema.cadastraGrupoNoSistema("Programação OO"));
        } catch (NullPointerException error) {}
    }
    
    @Test
    void testTentaAlocarNovamenteEmGrupo() {
        try {
            sistema.cadastraGrupoNoSistema("Programação OO");
            sistema.alocaAlunoEmGrupoSistema("200", "Programação OO");
            assertEquals("ALUNO ALOCADO!\n", sistema.alocaAlunoEmGrupoSistema("200", "Programação OO"));
            sistema.alocaAlunoEmGrupoSistema("200", "Programação OO");
    		assertEquals("ALUNO ALOCADO!\n", sistema.alocaAlunoEmGrupoSistema("200", "Programação OO"));
        } catch (NullPointerException error) {}    
    }

    @Test
    void testAlocaAlunoEmGrupoSistema() {
        try {
            sistema.cadastraGrupoNoSistema("Programação OO");
            assertEquals("ALUNO ALOCADO!\n", sistema.alocaAlunoEmGrupoSistema("200", "Programação OO"));
            assertEquals("ALUNO ALOCADO!\n", sistema.alocaAlunoEmGrupoSistema("202", "Programação OO"));
        } catch (NullPointerException error) {}
    }
    
    @Test
    void testTentaAlocarAlunoInexistenteEmGrupo() {
        try {
            sistema.cadastraGrupoNoSistema("Programação OO");
            assertEquals("ALUNO NÃO CADASTRADO!\n", sistema.alocaAlunoEmGrupoSistema("100", "Programação OO"));
        } catch (NullPointerException error) {}
    }
    
    @Test
    void testTentaAlocarAlunoEmGrupoInexistente() {
        try {
            assertEquals("GRUPO NÃO CADASTRADO!\n", sistema.alocaAlunoEmGrupoSistema("200", "Anatomia"));
        } catch (NullPointerException error) {}
    }
    
    @Test
    void testAlocaEmGrupoRestrito1() {
        sistema.cadastraGrupoLimitadoSistema("listas", 1);
        assertEquals("ALUNO ALOCADO!\n", sistema.alocaAlunoEmGrupoSistema("250", "Listas"));
        assertEquals("GRUPO CHEIO!\n", sistema.alocaAlunoEmGrupoSistema("202", "Listas"));
    }
    
    @Test
    void testChecaSeAlunoEstaEmGrupo() {
        try {
            sistema.alocaAlunoEmGrupoSistema("200", "JAVA");
            assertEquals("ALUNO PERTENCE AO GRUPO.\n", sistema.checaSeAlunoEstaEmGrupo("java", "200"));
        } catch (NullPointerException error) {}
    }
    
    @Test
    void testPertinenciaGrupo() {
        sistema.cadastraGrupoNoSistema("listas");
        sistema.alocaAlunoEmGrupoSistema("250", "Listas");
        assertEquals("ALUNO PERTENCE AO GRUPO.\n", sistema.checaSeAlunoEstaEmGrupo("Listas", "250"));
        assertEquals("ALUNO NÃO PERTENCE AO GRUPO.\n", sistema.checaSeAlunoEstaEmGrupo("Listas", "202"));
    }
    
    @Test
    void testPertinenciaGrupoInexistente() {
        try {
            assertEquals("GRUPO NÃO CADASTRADO.\n", sistema.checaSeAlunoEstaEmGrupo("Anatomia", "200"));
        } catch (NullPointerException error) {}
    }
    
    @Test
    void testPertinenciaAlunoInexistente() {
        try {
            sistema.cadastraGrupoNoSistema("Programação OO");
            assertEquals("ALUNO NÃO CADASTRADO.\n", sistema.checaSeAlunoEstaEmGrupo("Programação", "100"));
        } catch (NullPointerException error) {}
    }
    
    @Test
    void testChecaSeAlunoNaoEstaEmGrupo() {
        try {
            assertEquals("ALUNO NÃO PERTENCE AO GRUPO.\n", sistema.checaSeAlunoEstaEmGrupo("lp2", "202"));
        } catch (NullPointerException error) {}
    }

    @Test
    void testGruposQueAlunoParticipa() {
        try {
            sistema.alocaAlunoEmGrupoSistema("250", "lp2");
            assertEquals("LP2" , sistema.gruposQueAlunoParticipa("250"));
        } catch (NullPointerException error) {}
    }
    
    @Test
    void testExibeGruposDeAlunoSemGrupos() {
        assertEquals("", sistema.gruposQueAlunoParticipa("202"));
    }
    
    @Test
    void testExibeGruposDeAlunoComGrupos() {
        try {
            sistema.cadastraGrupoLimitadoSistema("Programação OO", 10);
            sistema.cadastraGrupoLimitadoSistema("Listas", 10);
            sistema.alocaAlunoEmGrupoSistema("250", "listas");
            sistema.alocaAlunoEmGrupoSistema("250", "Programação OO");
            assertEquals("- Listas: 1/10 \n - Programação OO: 1/10", sistema.gruposQueAlunoParticipa("250"));
        } catch (NullPointerException error) {}
    }

    @Test
    void testCadastraAlunoNoSistemaNomeNulo() {
        assertEquals("ALUNO INVÁLIDO!\n", sistema.cadastraAlunoSistema(null, "123", "Design"));
    }
    
    @Test
    void testCadastraAlunoSistemaMatriculaNula() {
        assertEquals("ALUNO INVÁLIDO!\n", sistema.cadastraAlunoSistema("Gabriel Reyes", null, "Computação"));
    }
    
    @Test
    void testCadastraAlunoSistemaCursoNulo() {
        assertEquals("ALUNO INVÁLIDO!\n", sistema.cadastraAlunoSistema("Livia Maria", "459", null));
    }
    
    @Test
    void testTentaRegistrarAlunoQueRespondeuInvalido() {
        assertEquals("ALUNO NÃO CADASTRADO.\n", sistema.registraAlunoQueRespondeu("092"));
    }
    
    @Test
    void testCadastraAlunoQueRespondeu() {
        assertEquals("ALUNO REGISTRADO!\n", sistema.registraAlunoQueRespondeu("200"));
    }
    
    @Test
    void testMostrarAlunosQueResponderam() {
        sistema.registraAlunoQueRespondeu("202");
        assertEquals("1. 202 - Angela Ziegler - Medicina\n", sistema.getAlunosQueResponderam());
    }
    
    @Test
    void testMostrarAlunosQueResponderam2() {
        sistema.registraAlunoQueRespondeu("202");
        sistema.registraAlunoQueRespondeu("201");
        assertEquals("1. 202 - Angela Ziegler - Medicina\n2. 201 - Torbjorn Lindholm - Engenharia Mecânica\n", sistema.getAlunosQueResponderam());
    }
    
    @Test
    void testMostrarAlunosQueResponderamVariasVezes() {
        sistema.registraAlunoQueRespondeu("250");
        sistema.registraAlunoQueRespondeu("200");
        sistema.registraAlunoQueRespondeu("200");
        sistema.registraAlunoQueRespondeu("250");
        assertEquals("1. 250 - Gabriel Reyes - Computação\n2. 200 - Lili Camposh - Computação\n3. 200 - Lili Camposh - Computação\n4. 250 - Gabriel Reyes - Computação\n", sistema.getAlunosQueResponderam());
    }
    
    @Test
    void testMostrarAlunosQueResponderamVariasVezes2() {
        sistema.registraAlunoQueRespondeu("202");
        sistema.registraAlunoQueRespondeu("201");
        sistema.registraAlunoQueRespondeu("201");
        sistema.registraAlunoQueRespondeu("202");
        assertNotEquals("1. 250 - Gabriel Reyes - Computação\n 2. 200 - Lili Camposh - Computação\n 3. 200 - Lili Camposh - Computação\n 4. 250 - Gabriel Reyes - Computação\n", sistema.getAlunosQueResponderam());
    }
}
