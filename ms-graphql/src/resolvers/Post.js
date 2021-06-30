const Post = {
    //author:(parent,args,{db},info)=>db.users.find(u=>u.id===parent.author),
    //comments:(parent,args,{db},info)=>db.comments.filter(c=>c.post==parent.id)

    comments:async (parent,{query},{prisma},info)=>{
        return prisma.query.comments(null, info)
    }
}

export {Post as default}