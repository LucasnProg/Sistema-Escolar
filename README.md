O sistema, possui 7 classes e ainda não possui API. Onde, cada classe representa
entidades diferentes e tem funcionalidades distintas. São alguns dos principais métodos:

1. Main:
○ menuPrincipal() → Método que incia o sistema, sendo como uma
“interface” no console.
○ menuAluno() → Método que atua como interface do aluno no console.
○ menuProfessor() → Método que atua como interface do professor no
console
○ menuCoordenador() → Método que atua como interface do coordenador
no console
○ Essas função ainda conta com outros métodos auxiliares e
complementares.
2. Usuario(superclasse):
○ getters e setter padrões
○ Algumas observações de métodos estão comentados no código.(login() e
redefinirSenha())
3. Aluno(subclasse de Usuario):
○ exibirDados() → Método que mostra para o aluno seus dados pessoais
○ cursarDisciplina() → Método onde o aluno escolhe uma disciplina para
cursar e adicionar ao seu boletim
○ trancarDisciplina() → Método onde o aluno pode desistir de uma
disciplina
○ exibirBoletim() → Método que mostra ao aluno suas disciplinas e suas
notas
○ Outros métodos auxiliares e complementares do aluno.
4. Professor(subclasse de Usuario):
○ inserirNota() → Método que adiciona uma nota ao aluno
○ exibirDisciplinas() → Método que mostra as disciplinas ministradas pelo
professor
○ exibirAlunos() → Método que mostra os aluno por disciplinas do professor
○ outros métodos auxiliares e complementares de professor.
5. Coordenador(subclasse de Usuario):
○ matricularAluno() e matricularProfessor() → Métodos que adicionam um novo

aluno e novo professor ao sistema, respectivamente
○ RemoverAluno() e removerProfessor() → Métodos que removem aluno e
professor do sistema, respectivamente
○ criarDisciplina() → Método que adiciona uma nova disciplina ao sistema
○ removerDisciplina() → Método que remove uma disciplina do sistema
○ exibirAlunos() e exibirProfessor() → Método que mostra todos os alunos e
professor cadastrados no sistema, respectivamente
○ exibirDisciplinas() → Método que mostra todas as disciplinas cadastradas no
sistema
○ outros métodos auxiliares e complementares.
6. Disciplina e Boletim:
○ São classes que são complementares do sistema, não possuem funcionalidades
explicitas ao Usuario. Contudo, possuem seus métodos próprios.
