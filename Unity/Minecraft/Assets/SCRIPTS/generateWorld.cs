using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class generateWorld : MonoBehaviour
{
    public GameObject[,,] world;
    public GameObject grass;
    public GameObject dirt;
    public GameObject cloud;
    public GameObject tree;
    public GameObject inimigo;
    private float height;

  
    
    // Start is called before the first frame update
    void Start(){
        world = new GameObject[50, 5, 50];
        createDynamicWorld();
        height=Random.Range(1f,20f);
    }

    // Update is called once per frame
    void Update(){
    }

    void createDynamicWorld(){
        for (int xx = 0; xx < world.GetLength(0);xx++){
            for (int yy = 0; yy < world.GetLength(1); yy++){
                 for (int zz = 0; zz < world.GetLength(2); zz++){
                        if (yy == world.GetLength(1) - 1){
                            world[xx, yy, zz] = Instantiate(grass, new Vector3(xx, yy, zz), Quaternion.identity);
                            if(Random.Range(0,100)<1f){
                                GameObject treeTemp= Instantiate(tree, new Vector3(xx, yy+1f, zz), Quaternion.identity);
                            }
                             if(Random.Range(0,100)<1f){
                                GameObject inimigoTemp= Instantiate(inimigo, new Vector3(xx, yy+10f, zz), Quaternion.identity);
                            }
                        }else{
                            world[xx, yy, zz] = Instantiate(dirt, new Vector3(xx, yy , zz ), Quaternion.identity);
                     }
                }
            }
        }
           for (int i =0; i < 2; i++){
            float xx = world.GetLength(0);
            float yy = world.GetLength(1) + 8+height;
            float zz =  (i*30);
            Instantiate(cloud,new Vector3(xx,yy,zz),Quaternion.identity);
        }
        for (int i = 0; i < 2; i++){
            float xx = world.GetLength(0)/2;
            float yy = world.GetLength(1) + 8+height;
            float zz = (i * 30);
            Instantiate(cloud, new Vector3(xx, yy, zz), Quaternion.identity);
        }
        for (int i = 0; i < 2; i++){
            float xx = 0;
            float yy = world.GetLength(1) + 8+height;
            float zz = (i * 30);
            Instantiate(cloud, new Vector3(xx, yy, zz), Quaternion.identity);
        }
    }
}
