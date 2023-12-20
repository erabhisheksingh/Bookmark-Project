import Image from 'next/image'

export default function Home() {
  return (
    <main className="flex min-h-screen flex-col items-center justify-between p-24">
      <div className="z-10 max-w-5xl w-full items-center justify-between font-mono text-sm lg:flex">
       <nav className="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
         <div className="container-fluid">
           <img src="../bookmark.png" width="30" height="24" class="d-inline-block align-text-top"/>
           <button className="btn btn-primary" type="submit">Add Bookmark</button>
         </div>
       </nav>
      </div>
    </main>
  )
}
