# Projeto Android com Kotlin
Este projeto foi desenvolvido utilizando a linguagem Kotlin e é focado em criação de telas de login, registro, home, perfil e criação/edição de tarefas. Além disso, o projeto usa o gerenciamento de temas com cores personalizadas e navegação entre as telas utilizando Intents.

## Funcionalidades
* Tela de Login: Tela de login simples onde o usuário pode se autenticar para acessar a aplicação.
* Tela de Registro: Tela para criação de uma nova conta de usuário.
* Tela Home: A tela principal após o login, com navegação para outras funcionalidades.
* Tela de Nova/Edição de Tarefa: Tela onde o usuário pode criar ou editar tarefas.
* Tela de Perfil: Tela de exibição e edição de perfil do usuário.
* 
## Navegação Entre Telas
* Login → Registro: A navegação é realizada utilizando Intent para permitir que o usuário se registre.
* Registro → Login: Permite que o usuário volte para a tela de login.
* Login → Home: Após o login bem-sucedido, o usuário é redirecionado para a tela inicial (Home).
* Home → Perfil: Navegação entre a tela principal e o perfil do usuário.
* Home → Criar/Editar Tarefa: Navegação para a tela de criação/edição de tarefas.
* Logout → Login: O usuário pode se deslogar da tela Home, voltando para a tela de login.
  
## Configurações de Cores e Temas
* strings.xml: Variáveis de ambiente configuradas para strings reutilizáveis em todo o projeto.
* colors.xml: Variáveis de ambiente configuradas para as cores personalizadas que são utilizadas em todo o aplicativo.
* themes.xml: Arquivos de tema configurados para as versões light e dark, permitindo alternância de tema entre claro e escuro.

## Tecnologias Utilizadas
* Kotlin: A linguagem de programação principal para o desenvolvimento.
* Intents: Usado para navegar entre as atividades dentro do aplicativo.
* Android SDK: Conjunto de ferramentas para desenvolvimento de aplicativos Android.
  
## Como Rodar o Projeto
1. Clone o repositório:
```bash
  git clone https://github.com/Markos-Vini/app-kotlin.git
```

2. Abra o projeto no Android Studio:
* No Android Studio, clique em Open e selecione o diretório do projeto clonado.

4. Execute o Projeto:
* Clique em Run no Android Studio para compilar e rodar o aplicativo no seu emulador ou dispositivo Android.
