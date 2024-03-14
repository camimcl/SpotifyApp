package musicaspackage;
public class Musicas {
    private int id;
    private String name; 
    private String album;
    private String artista;
    private String caminhoImagem;
    private String caminhoAudio;

    
    public String getCaminhoAudio() {
        return caminhoAudio;
    }
    public void setCaminhoAudio(String caminhoAudio) {
        this.caminhoAudio = caminhoAudio;
    }
    public Musicas(String name, String album, String artista) {
        this.name = name;
        this.album = album;
        this.artista = artista;
    }
    public String getAlbum() {
        return album;
    }
    public void setAlbum(String album) {
        this.album = album;
    }
    public String getArtista() {
        return artista;
    }
    public void setArtista(String artista) {
        this.artista = artista;
    }
    public String getCaminhoImagem() {
        return caminhoImagem;
    }
    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  
    
}
