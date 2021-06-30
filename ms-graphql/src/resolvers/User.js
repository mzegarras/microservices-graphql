import getUserId from "../utils/getUserId";

const User = {
    //posts:(parent,args,{db,prisma},info)=>db.posts.filter(p=>p.author==parent.id),
    //comments:(parent,args,{db},info)=>db.comments.filter(p=>p.author==parent.id)
    posts:{
        fragment: 'fragment userId on User { id }',
        resolve(parent,args,{prisma,request},info){

            const userId = getUserId(request,false);
            

            const optArgs = {
                where:{
                    author: {
                        id: parent.id
                    },
                    published: true
                }
            };

            // if(userId && userId!==parent.id){
            //     optArgs.where.published=true;
            // }
                        
            return prisma.query.posts(optArgs,info);


        }
    },
    email:{
        fragment: 'fragment userId on User { id }',
        resolve(parent,args,{request},info){
            const userId = getUserId(request,false);
    
            
            //console.log(userId);
            //console.log(JSON.stringify(parent));
    
            if(userId && userId===parent.id){
                return parent.email;
            }else{
                return null;
            }
    
        }

    }
}

export {User as default}