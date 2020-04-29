package DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.company.Produto;

public class ProdutoDAO implements DAO<Produto, Integer>{


    private List<Produto> produtos;

    private File file;
    private FileOutputStream fos;
    private ObjectOutputStream outputFile;

    public ProdutoDAO(String filename) throws IOException {
        produtos = new ArrayList<Produto>();
        file = new File(filename);
        if (file.exists())
            readFromFile();
    }

    @Override
    public void add(Produto produto) {
        produtos.add(produto);
        saveToFile();
    }

    @Override
    public Produto get(Integer chave) {
        for (Produto produto : produtos) {
            if (chave.intValue() == produto.getId()) {
                return produto;
            }
        }
        return null;

    }

    @Override
    public List<Produto> getAll() {

        return produtos;
    }

    @Override
    public void update(Produto produto) {
        int index = produtos.indexOf(produto);
        System.out.println(index);
        if (index != -1) {
            produtos.set(index, produto);
            saveToFile();
        }
    }

    @Override
    public void remove(Produto produto) {
        int index = produtos.indexOf(produto);
        if (index != -1) {
            produtos.remove(index);
        }
        saveToFile();

    }

    private void readFromFile() {
        Produto produto;
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream inputFile = new ObjectInputStream(fis)) {

            while (fis.available() > 0) {
                produto = (Produto) inputFile.readObject();
                produtos.add(produto);
            }
        } catch (Exception e) {
            System.out.println("ERRO ao ler Produto do disco!");
            e.printStackTrace();
        }
    }

    private void saveToFile() {
        try (FileOutputStream fos = new FileOutputStream(file, false);
             ObjectOutputStream outputFile = new ObjectOutputStream(fos)) {

            for (Produto p : produtos) {
                outputFile.writeObject(p);
            }
            outputFile.flush();
        } catch (Exception e) {
            System.out.println("ERRO ao gravar Produto no disco!");
            e.printStackTrace();
        }

    }

    private void close() throws IOException {
        outputFile.close();
        fos.close();
    }

    @Override
    protected void finalize() throws Throwable {
        this.close();
    }
}
