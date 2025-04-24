package controle_estoque;

interface ReprodutorMusical{
    void tocar();
    void pausar();
    void selecionarMusica(String musica);
}

interface AparelhoTelefonico{
    void tocar();

    void pausar();

    void selecionarMusica(String musica);

    void ligar(String numero);
    void atender();
    void iniciarCorreioVoz();
}

interface NavegadorInternet {
    void exibirPagina(String url);
    void adicionarNovaAba();
    void atualizarPagina();
}

class Iphone implements AparelhoTelefonico, NavegadorInternet{

    @Override
    public void tocar() {
        System.out.println("Reproduzindo Música");
    }

    @Override
    public void pausar() {
        System.out.println("Música pausada");
    }

    @Override
    public void selecionarMusica(String musica) {
        System.out.println("Selecionando música: " + musica);
    }

    @Override
    public void ligar(String numero) {
        System.out.println("Ligar para " + numero);
    }

    @Override
    public void atender() {
        System.out.println("Atendendo chamada");
    }

    @Override
    public void iniciarCorreioVoz() {
        System.out.println("Iniciando correio de voz");
    }

    @Override
    public void exibirPagina(String url) {
        System.out.println("Exibindo página: " + url);
    }

    @Override
    public void adicionarNovaAba() {
        System.out.println("Mova aba adicionada");
    }

    @Override
    public void atualizarPagina() {
        System.out.println("Página atualizada");
    }

    public static void main(String[] args) {
        Iphone meuIphone = new Iphone();

        meuIphone.tocar();
        meuIphone.selecionarMusica("505 - Arctic Monkeys");
        meuIphone.pausar();

        meuIphone.ligar("(12) 34567 8900");
        meuIphone.atender();
        meuIphone.iniciarCorreioVoz();

        meuIphone.exibirPagina("https://www.google.com");
        meuIphone.adicionarNovaAba();
        meuIphone.atualizarPagina();
    }
}
